#!/usr/bin/env python
import string
import json
from json import JSONEncoder


class MachineState(object):
    current_state = string

    def __init__(self, state=string):
        self.current_state = state

    def to_json(self):
        return json.dumps(self, cls=CommandEncoder)

    @staticmethod
    def from_json(json_string):
        return json.loads(json_string, object_hook=MachineState.map_json)

    @staticmethod
    def map_json(json_dct):
        return MachineState(json_dct['current_state'])

class CommandEncoder(JSONEncoder):
    def default(self, obj):
        return obj.__dict__
