#!/usr/bin/env python
from simple_pid import PID


class controlled_system:
    def __init__(self, initial_value=0):
        self.state = initial_value

    @staticmethod
    def update(new_value) -> float:
        return new_value


pid = PID(0.4, 0.1, 0, setpoint=1)

# Assume we have a system we want to control in controlled_system
v = controlled_system.update(0)

while True:
    # Compute new output from the PID according to the systems current value
    control = pid(v)

    # Feed the PID output to the system and get its current value
    v = controlled_system.update(control)
    print(v)
