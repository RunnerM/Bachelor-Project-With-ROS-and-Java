#!/usr/bin/env python
from __future__ import print_function
from machine_ws.src.autogator.srv import CommandNet, CommandNetResponse
from std_msgs.msg import String
import os
import rospy

from autogator.msg import location, cmd_req
from autogator.services.masterService import MasterService
from autogator.utils.autogator_worker import AutogatorWorker


class master:

    def __init__(self):
        rospy.init_node('master', anonymous=False)

        # Callback should be in a service itself
        rospy.Subscriber("gps_location", location, MasterService.prepare_coordinates)
        rospy.Subscriber("command", cmd_req, MasterService.handle_command)
        rospy.Subscriber("command_req", cmd_req, MasterService.handle_start_recording_route(cmd_req.success))
        rospy.logininfo("Master Started.")
        # Thread for publishing gps_track
        # Maybe update with another method
        publish_coord = AutogatorWorker("gps_location", function=MasterService.prepare_coordinates(location))
        publish_coord.start()

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        master()
    except rospy.ROSInterruptException:
        pass
