#!/usr/bin/env python
import rospy


class SelfDrivingService:

    def __init__(self):
        pass

    @staticmethod
    def handle_seldriving_location(location):
        # This is here to display better separation of concerns as of now.
        # Should be updated with proper methods
        # update_selfdrive_map // delete_selfdrive_map // replace_selfdrive_map

        rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", location.longitude, location.latitude,
                      location.rotation)

        pass
