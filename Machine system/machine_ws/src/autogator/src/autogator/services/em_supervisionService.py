#!/usr/bin/env python
import rospy
from autogator.msg import location
from autogator.models.location import Location


class EmergencySupervisionService:

    def __init__(self):

        pass

    @staticmethod
    def handle_emergency_situation(location_):
        # This is here to display better separation of concerns as of now.
        # Should be updated with proper methods
        # emergency_break?
        longitude = Location(location_.longitude)
        latitude = Location(location_.latitude)
        rotation = Location(location_.rotation)
        rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", longitude, latitude, rotation)