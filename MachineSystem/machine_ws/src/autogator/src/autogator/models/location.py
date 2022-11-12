#!/usr/bin/env python

import json
from json import JSONEncoder


#In case it is needed for future use.
class Location(object):
    longitude = float
    latitude = float
    rotation = float

    def __init__(self, longitude=float, latitude=float, rotation=float):
        self.longitude = longitude
        self.latitude = latitude
        self.rotation = rotation

    def to_json(self):
        return json.dumps(self, cls=CommandEncoder)

    @staticmethod
    def from_json(json_string):
        return json.loads(json_string, object_hook=Location.map_json)

    @staticmethod
    def map_json(json_dct):
        return Location(json_dct['longitude'],
                        json_dct['latitude'],
                        json_dct['rotation'])


class CommandEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__
