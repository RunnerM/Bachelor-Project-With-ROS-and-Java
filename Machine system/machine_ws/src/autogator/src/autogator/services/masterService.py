#!/usr/bin/env python
import rospy
from autogator.msg import location
from autogator.models.location import Location


class MasterService:


    def __init__(self):
        pass

    @staticmethod
    def prepare_coordinates(location_):
        # This is here to display better separation of concerns as of now.
        # Should be updated with proper methods
        # prepare the coords here
        longitude = Location(location_.longitude)
        latitude = Location(location_.latitude)
        rotation = Location(location_.rotation)
        rospy.logininfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", longitude, latitude, rotation)

    @staticmethod
    def handle_new_point_to_route(data):
        # handle message from gps node on new location and add it to recording path
        pass

    @staticmethod
    def handle_start_recording_route(command):
        # handle the start recording command
        pass

    @staticmethod
    def handle_command(command):
        # handle cmd here and pass to proper func by type.
        pass

