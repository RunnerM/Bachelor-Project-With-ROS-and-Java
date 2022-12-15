#!/usr/bin/env python
from __future__ import print_function
import rospy

from autogator.msg import Location, CmdReq
from autogator.services.masterService import MasterService


class master:

    def __init__(self):
        rospy.init_node('master', anonymous=False)
        self.master_service = MasterService()
        rospy.Subscriber("gps_location", Location, self.master_service.handle_new_gps_location)
        rospy.Subscriber("command", CmdReq, self.master_service.handle_command)
        rospy.loginfo("Master Started.")

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        master()
    except rospy.ROSInterruptException:
        pass
