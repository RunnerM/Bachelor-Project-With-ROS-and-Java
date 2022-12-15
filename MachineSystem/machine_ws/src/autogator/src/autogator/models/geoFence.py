#!/usr/bin/env python
import json
from json import JSONEncoder

from autogator.models.gpsTrack import GpsPoint


# The Fence represented by a main rectangle and further defined by a list of subtraction rectangles.
# All rectangles are defined by two points, the top left and the bottom right A and B.
# A---B
# |   |
# D---C
class Obstacle(object):
    a = GpsPoint
    c = GpsPoint

    def __init__(self, a=float, c=float):
        self.a = a
        self.c = c
        pass

    def set_boundary(self, a, c):
        self.a = a
        self.c = c
        return

    @staticmethod
    def from_json(json_string):
        return json.loads(json_string, object_hook=Obstacle.map_json)

    @staticmethod
    def map_json(json_dct):
        if 'latitude' in json_dct.keys():
            return GpsPoint.map_json(json_dct)
        elif 'a' in json_dct.keys():
            return Obstacle(json_dct['a'], json_dct['c'])
        else:
            return json_dct


class GeoFence(object):
    name = str
    A = GpsPoint
    C = GpsPoint
    obstacles = [Obstacle]

    def __init__(self, a=GpsPoint, c=GpsPoint, obstacles=None):
        if obstacles is None:
            self.obstacles = []
        else:
            self.obstacles = obstacles
        if a is None:
            self.A = GpsPoint(0, 0)
        if c is None:
            self.C = GpsPoint(0, 0)
        else:
            self.A = a
            self.C = c

    def set_fence(self, a, c):
        self.A = a
        self.C = c
        return

    # Checks if the point is within the geofence boundaries and does not intersect any obstacles
    def add_obstacle(self, obstacle=Obstacle):
        if self.check_point_in_fence(obstacle.a) and self.check_point_in_fence(obstacle.c):
            self.obstacles.append(obstacle)
            return True
        return False

    # Removes the obstacle from the list of obstacles
    def remove_obstacle(self, obstacle=Obstacle):
        self.obstacles.remove(obstacle)
        return

    # This function checks if the point is within the geofence boundaries and outside any obstacles
    def check_point_in_fence(self, point=GpsPoint) -> bool:
        if self.A is not None or self.C is not None:
            if self.A.latitude > point.latitude > self.C.latitude and self.A.longitude < point.longitude < self.C.longitude:
                for obstacle in self.obstacles:
                    if (obstacle.a.latitude > point.latitude > obstacle.c.latitude and
                            obstacle.a.longitude < point.longitude < obstacle.c.longitude):
                        return False
                return True
            return False
        return False

    def to_json(self):
        return json.dumps(self, cls=GeoFenceEncoder)

    @staticmethod
    def from_json(json_string):
        return json.loads(json_string, object_hook=GeoFence.map_json)

    @staticmethod
    def map_json(json_dct):
        if 'latitude' in json_dct.keys():
            return GpsPoint.map_json(json_dct)
        elif 'a' in json_dct.keys():
            return Obstacle.map_json(json_dct)
        elif 'obstacles' in json_dct.keys():
            return GeoFence(json_dct['A'], json_dct['C'], json_dct['obstacles'])
        else:
            return json_dct

    def to_api_model(self):
        obstacles = "["
        for obstacle in self.obstacles:
            obstacles += '{"pointALatitude"' + ':' + str(obstacle.a.latitude) + ',' + '"pointALongitude"' + ':' + str(
                obstacle.a.longitude) + ',' + '"pointBLatitude"' + ':' + str(
                obstacle.c.latitude) + ',' + '"pointBLongitude"' + ':' + str(obstacle.c.longitude) + '},'
        obstacles = obstacles[:-1].strip(",")
        obstacles += "]"
        return json.dumps({
            "pointALatitude": self.A.latitude,
            "pointALongitude": self.A.longitude,
            "pointBLatitude": self.C.latitude,
            "pointBLongitude": self.C.longitude,
            "geofenceName": self.name,
            "geofenceInternalBoundaries": obstacles
        })

    @staticmethod
    def from_api_model(json_string):
        if json_string is None:
            return GeoFence()
        res = GeoFence()
        json_dct = json.loads(json_string)
        res.A = GpsPoint(json_dct['pointALongitude'], json_dct['pointALatitude'])
        res.C = GpsPoint(json_dct['pointBLongitude'], json_dct['pointBLatitude'])
        res.name = json_dct['geofenceName']
        res.obstacles = []
        obstacles = json_dct['geofenceInternalBoundaries']
        read_obstacles = json.loads(obstacles)
        for obstacle in read_obstacles:
            res.obstacles.append(Obstacle(GpsPoint(obstacle['pointALongitude'], obstacle['pointALatitude']),
                                          GpsPoint(obstacle['pointBLongitude'], obstacle['pointBLatitude'])))
        return res


class GeoFenceEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__
