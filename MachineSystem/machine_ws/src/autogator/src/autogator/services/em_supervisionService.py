#!/usr/bin/env python
import rospy


class EmergencySupervisionService:

    def __init__(self):
        pass

    @staticmethod
    def handle_emergency_situation(location):
        # This is here to display better separation of concerns as of now.
        # Should be updated with proper methods
        # emergency_break?

        rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", location.longitude, location.latitude,
                      location.rotation)

    @staticmethod
    def handle_emergency_stop(location):
        # send stop request to selfdriving

        rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", location.longitude, location.latitude,
                      location.rotation)

        #
