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


