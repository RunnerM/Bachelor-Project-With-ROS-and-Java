#!/usr/bin/env python
import rospy
from autogator.msg import location
from autogator.models.location import Location


class SelfDrivingService:

    def __init__(self):

        pass

    @staticmethod
    def handle_seldriving_location(location_):
        # This is here to display better separation of concerns as of now.
        # Should be updated with proper methods
        # update_selfdrive_map // delete_selfdrive_map // replace_selfdrive_map
        longitude = Location(location_.longitude)
        latitude = Location(location_.latitude)
        rotation = Location(location_.rotation)
        rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", longitude, latitude, rotation)

