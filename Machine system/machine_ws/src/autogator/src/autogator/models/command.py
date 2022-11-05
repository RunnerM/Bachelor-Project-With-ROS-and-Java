#!/usr/bin/env python
import string
import json
from json import JSONEncoder


class Command(object):
    command_type = string
    time = string
    state = string

    def __init__(self, command_type=string, time=string, state=string):
        self.command_type = command_type
        self.time = time
        self.state = state

    def to_json(self):
        return json.dumps(self, cls=CommandEncoder)

    @staticmethod
    def from_json(json_string):
        return json.loads(json_string, object_hook=Command.map_json)

    @staticmethod
    def map_json(json_dct):
        return Command(json_dct['command_type'],
                       json_dct['time'], json_dct['state'])


class CommandEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__
