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


class GeoFence(object):
    a = GpsPoint
    c = GpsPoint
    obstacles = [Obstacle]

    def __init__(self, a=float, c=float):
        self.a = a
        self.c = c
        self.obstacles = []

    def set_fence(self, a, c):
        self.a = a
        self.c = c
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
        if self.a.latitude > point.latitude > self.c.latitude and self.a.longitude > point.longitude > self.c.longitude:
            for obstacle in self.obstacles:
                if (obstacle.a.latitude > point.latitude > obstacle.c.latitude and
                        obstacle.a.longitude > point.longitude > obstacle.c.longitude):
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
        return GeoFence(json_dct['a'], json_dct['c'], json_dct['obstacles'])


class GeoFenceEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__
