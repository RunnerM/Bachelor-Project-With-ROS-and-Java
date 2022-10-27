#!/usr/bin/env python
import json
from json import JSONEncoder

from src.autogator.src.utils.models.gpsTrack import GpsPoint


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
    A = GpsPoint
    C = GpsPoint
    obstacles = [Obstacle]

    def __init__(self, a=float, c=float, obstacles=None):
        if obstacles is None:
            self.obstacles = []
        else:
            self.obstacles = obstacles
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
    def check_point_in_fence(self, point=GpsPoint):
        if self.A.latitude > point.latitude > self.C.latitude and self.A.longitude > point.longitude > self.C.longitude:
            for obstacle in self.obstacles:
                if (obstacle.A.latitude > point.latitude > obstacle.C.latitude and
                        obstacle.A.longitude > point.longitude > obstacle.C.longitude):
                    return False
            return True
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


class GeoFenceEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__
