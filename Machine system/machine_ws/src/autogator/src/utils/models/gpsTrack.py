#!/usr/bin/env python
import string
import json
from json import JSONEncoder


# The object meant to follow the DD GPS format which stands for Decimal degrees.
class GpsPoint(object):
    latitude = float
    longitude = float

    def __init__(self, latitude, longitude):
        self.latitude = latitude
        self.longitude = longitude
        pass


class GpsTrack(object):
    track_name = string
    points = [GpsPoint]

    def __init__(self, track_name=string):
        self.points = []
        self.track_name = track_name
        pass

    def add_track_point(self, track_point=GpsPoint):
        self.points.append(track_point)
        return

    def remove_point(self, track_point=GpsPoint):
        self.points.remove(track_point)

    def to_json(self):
        return json.dumps(self, cls=GpsTrackEncoder)

    @staticmethod
    def from_json(json_string):
        return json.loads(json_string, object_hook=GpsTrack.map_json)

    @staticmethod
    def map_json(json_dct):
        return GpsTrack(json_dct['track_name'], json_dct['points'])



class GpsTrackEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__
