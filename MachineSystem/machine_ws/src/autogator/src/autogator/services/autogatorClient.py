#!/usr/bin/env python
import http.client
import json
from typing import Optional

import rospy

from autogator.models.command import Command
from autogator.models.geoFence import GeoFence
from autogator.models.gpsTrack import GpsTrack, GpsPoint
from autogator.models.machineState import MachineState


class AutogatorClient:
    API_BASE_URL = "autogator-servcie.herokuapp.com"
    MACHINE_SERIAL_NUMBER = "test_serial_05"

    def __init__(self):
        pass

    def get_command(self):
        try:
            connection = http.client.HTTPSConnection(self.API_BASE_URL)
            connection.request("GET", "/command" + "?machineSerialNumber=" + self.MACHINE_SERIAL_NUMBER)
            response = connection.getresponse()
            if response.status == 200:
                body_str = response.read().decode()
                json_dict = json.loads(body_str)
                command_dict = json_dict['command']
                command = Command(command_dict['command'], command_dict['timeIssued'], command_dict['commandState'])
                route = json_dict['irrigationRoute']
                gps_track = GpsTrack.from_api_model(route)
                fence = json_dict['geofence']
                gps_fence = GeoFence.from_api_model(fence)
                connection.close()
                return command, gps_track, gps_fence
            if response.status == 500:
                connection.close()
                return Command("Default", "None", "None"), None, None
            else:
                connection.close()
                return None, None, None
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
            connection.request("POST", "/irrigationRoute", gps_track.to_api_model(), headers)
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
            connection.request("POST", "/machineState" + "?machineStateEnum=" + state.current_state + "&machineSerialNumber=" + self.MACHINE_SERIAL_NUMBER)
            response = connection.getresponse()
            if response.status == 200:
                response_str = response.read().decode()
                json_dict = json.loads(response_str)
                if json_dict["machineStateEnum"] == state.current_state:
                    connection.close()
                    return True
                connection.close()
                return False
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
            params = "?location=" + str(location.latitude) + ";%20" + str(
                location.longitude) + "&machineSerialNumber=" + self.MACHINE_SERIAL_NUMBER
            connection.request("POST", "/machineLocation" + params, None, headers)
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
