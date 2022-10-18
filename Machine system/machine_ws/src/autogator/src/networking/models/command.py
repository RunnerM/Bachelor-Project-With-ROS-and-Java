import string
import json


class Command:
    command_type = string
    time = string
    state = string

    def __init__(self, command_type=string, time=string, state=string):
        self.command_type = command_type
        self.time = time
        self.state = state

    def to_json(self):
        return json.dumps(self)
