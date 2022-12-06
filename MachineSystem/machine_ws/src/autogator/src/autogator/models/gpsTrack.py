#!/usr/bin/env python
import string
import json
from json import JSONEncoder


# The object meant to follow the DD GPS format which stands for Decimal degrees.
class GpsPoint(object):
    latitude = float
    longitude = float

    def __init__(self, longitude=float, latitude=float):
        self.latitude = latitude
        self.longitude = longitude
        pass

    def to_json(self):
        return json.dumps(self, cls=GpsPointEncoder)

    @staticmethod
    def from_json(json_string):
        return json.loads(json_string, object_hook=GpsPoint.map_json)

    @staticmethod
    def map_json(json_dct):
        return GpsPoint(json_dct['longitude'], json_dct['latitude'])


class GpsPointEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__


class GpsTrack(object):
    track_name = string
    points = [GpsPoint]

    def __init__(self, track_name=string, points=[]):
        if points is None:
            self.points = []
        else:
            self.points = points
        self.track_name = track_name
        pass

    def add_track_point(self, track_point=GpsPoint):
        self.points.append(track_point)
        return

    def remove_point(self, track_point=GpsPoint):
        self.points.remove(track_point)

    def empty_track(self):
        self.points.clear()

    def to_json(self):
        return json.dumps(self, cls=GpsTrackEncoder)

    @staticmethod
    def from_json(json_string=string):
        return json.loads(json_string, object_hook=GpsTrack.map_json)

    @staticmethod
    def map_json(json_dct):
        if 'latitude' in json_dct.keys():
            return GpsPoint.map_json(json_dct)
        elif 'track_name' in json_dct.keys():
            return GpsTrack(json_dct['track_name'], json_dct['points'])
        else:
            return json_dct

    def to_api_model(self):
        points = ""
        for point in self.points:
            points += "[" + str(point.latitude) + "," + str(point.longitude) + "],"
        points = points[:-1]
        return json.dumps({"routeName": self.track_name, "routePoints": points})

    @staticmethod
    def from_api_model(api_model):
        if api_model is None:
            return None
        json_dct = json.loads(api_model)
        track_name = json_dct["routeName"]
        points = json_dct["routePoints"]
        points = points[1:-1]
        points = points.split("],[")
        buffer = []
        for point in points:
            #point = point[1:]
            point = point.split(",")
            buffer.append(GpsPoint(float(point[1]), float(point[0])))
        return GpsTrack(track_name, buffer)


class GpsTrackEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__
