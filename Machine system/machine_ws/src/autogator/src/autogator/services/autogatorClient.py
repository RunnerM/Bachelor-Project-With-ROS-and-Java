#!/usr/bin/env python
import http.client
from typing import Optional

import rospy

from src.autogator.src.autogator.models.command import Command
from src.autogator.src.autogator.models.gpsTrack import GpsTrack


class AutogatorClient:
    API_BASE_URL = "utogator-servcie.herokuapp.com"

    def __init__(self):
        pass

    def get_command(self) -> Optional[Command]:
        try:
            connection = http.client.HTTPSConnection(self.API_BASE_URL)
            connection.request("GET", "/command")
            response = connection.getresponse()
            body_str = response.read().decode()
            command = Command.from_json(body_str)
            connection.close()
            return command
        except Exception as e:
            rospy.loginfo(e)
            return None

    def post_command(self, command=Command) -> bool:
        try:
            connection = http.client.HTTPSConnection(self.API_BASE_URL)
            headers = {'Content-type': 'application/json'}
            connection.request("POST", "/command", command.to_json(), headers)
            response = connection.getresponse()
            hello_str = response.read().decode()
            rospy.loginfo(hello_str)
            connection.close()
            return True
        except Exception as e:
            rospy.loginfo(e)
            return False

    def post_track(self, gps_track=GpsTrack) -> bool:
        try:
            connection = http.client.HTTPSConnection(self.API_BASE_URL)
            headers = {'Content-type': 'application/json'}
            connection.request("POST", "/new-track", gps_track.to_json(), headers)
            response = connection.getresponse()
            hello_str = response.read().decode()
            rospy.loginfo(hello_str)
            connection.close()
            return True
        except Exception as e:
            rospy.loginfo(e)
            return False

    def post_state(self, machine_state) -> bool:
        pass

    def post_location(self, location) -> bool:
        pass
