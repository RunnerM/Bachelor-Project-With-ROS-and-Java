#!/usr/bin/env python
from __future__ import print_function
import rospy

from autogator.msg import Location, CmdReq
from autogator.services.masterService import MasterService


class master:

    def __init__(self):
        rospy.init_node('master', anonymous=False)

        # Callback should be in a service itself
        self.master_service = MasterService()
        rospy.Subscriber("gps_location", Location, self.master_service.handle_new_gps_location)
        rospy.Subscriber("command", CmdReq, self.master_service.handle_command)
        rospy.loginfo("Master Started.")
        # Thread for publishing gps_track
        # Maybe update with another method

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        master()
    except rospy.ROSInterruptException:
        pass
