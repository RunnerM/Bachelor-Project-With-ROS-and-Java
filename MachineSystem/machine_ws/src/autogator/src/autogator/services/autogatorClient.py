#!/usr/bin/env python
import http.client
from typing import Optional

import rospy

from autogator.models.command import Command
from autogator.models.gpsTrack import GpsTrack, GpsPoint
from autogator.models.machineState import MachineState


class AutogatorClient:
    API_BASE_URL = "utogator-servcie.herokuapp.com"

    def __init__(self):
        pass

    def get_command(self) -> Optional[Command]:
        try:
            connection = http.client.HTTPSConnection(self.API_BASE_URL)
            connection.request("GET", "/command")
            response = connection.getresponse()
            if response.status == 200:
                body_str = response.read().decode()
                command = Command.from_json(body_str)
                connection.close()
                return command
            else:
                connection.close()
                return None
        except Exception as e:
            rospy.loginfo(e)
            return None

    def post_command(self, command=Command) -> bool:
        try:
            connection = http.client.HTTPSConnection(self.API_BASE_URL)
            headers = {'Content-type': 'application/json'}
            connection.request("POST", "/command", command.to_json(), headers)
            response = connection.getresponse()
            if response.status == 200:
                connection.close()
                return True
            else:
                connection.close()
                return False
        except Exception as e:
            rospy.loginfo(e)
            return False

    def post_track(self, gps_track=GpsTrack) -> bool:
        try:
            connection = http.client.HTTPSConnection(self.API_BASE_URL)
            headers = {'Content-type': 'application/json'}
            connection.request("POST", "/new-track", gps_track.to_json(), headers)
            response = connection.getresponse()
            if response.status == 200:
                connection.close()
                return True
            else:
                connection.close()
                return False
        except Exception as e:
            rospy.loginfo(e)
            return False

    def post_state(self, state=MachineState) -> bool:
        try:
            connection = http.client.HTTPSConnection(self.API_BASE_URL)
            headers = {'Content-type': 'application/json'}
            connection.request("POST", "/machine-state", state.to_json(), headers)
            response = connection.getresponse()
            if response.status == 200:
                connection.close()
                return True
            else:
                connection.close()
                return False
        except Exception as e:
            rospy.loginfo(e)
            return False
        pass

    def post_location(self, location=GpsPoint) -> bool:
        try:
            connection = http.client.HTTPSConnection(self.API_BASE_URL)
            headers = {'Content-type': 'application/json'}
            connection.request("POST", "/location", location.to_json(), headers)
            response = connection.getresponse()
            if response.status == 200:
                connection.close()
                return True
            else:
                connection.close()
                return False
        except Exception as e:
            rospy.loginfo(e)
            return False
        pass
