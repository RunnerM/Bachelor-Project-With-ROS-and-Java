#!/usr/bin/env python
import string
import json
from json import JSONEncoder


# The object meant to follow the DD GPS format which stands for Decimal degrees.
class GpsTrackPoint(object):
    latitude = float
    longitude = float

    def __init__(self, latitude, longitude):
        self.latitude = latitude
        self.longitude = longitude
        pass


class GpsTrack(object):
    track_name = string
    points = [GpsTrackPoint]

    def __init__(self, track_name=string):
        self.points = []
        self.track_name = track_name
        pass

    def add_track_point(self, track_point=GpsTrackPoint):
        self.points.append(track_point)
        return

    def remove_point(self, track_point=GpsTrackPoint):
        self.points.remove(track_point)

    def to_json(self):
        return json.dumps(self, cls=GpsTrackEncoder)


class GpsTrackEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__
