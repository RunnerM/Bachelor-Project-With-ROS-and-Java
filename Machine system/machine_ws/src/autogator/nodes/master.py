#!/usr/bin/env python
from __future__ import print_function
from autogator.srv import CommandNet, CommandNetResponse
from autogator.msg import cmd_req
import os
import rospy

from autogator.msg import location
from autogator.services.masterService import MasterService


def commandNet(req):
    print("Returning [%s , %s , %s]" % (req.a, req.b, req.t))
    return CommandNetResponse(req.a + req.b)


def callback(data):
    rospy.loginfo(rospy.get_caller_id() + "Data Received %s", data.data)


class master:

    def __init__(self):
        rospy.init_node('master', anonymous=False)

        # Callback should be in a service itself
        rospy.Subscriber("gps_location", location, MasterService.prepare_coordinates)
        rospy.Subscriber("command", cmd_req, MasterService.handle_command)
        rospy.logininfo("Master Started.")

        # Thread for publishing gps_track
        pub = rospy.Publisher('gps_track', os.path.basename('../utils/models/gpsTrack.py'), queue_size=10)

        service_s = rospy.Service('CommandNet', CommandNet, commandNet)

        print(service_s)

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        master()
    except rospy.ROSInterruptException:
        pass
