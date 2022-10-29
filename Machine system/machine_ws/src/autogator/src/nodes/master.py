#!/usr/bin/env python
from __future__ import print_function
from machine_ws.src.autogator.srv import CommandNet, CommandNetResponse
from std_msgs.msg import String
import os
import rospy


def commandNet(req):
    print("Returning [%s , %s , %s]" % (req.a, req.b, req.t))
    return CommandNetResponse(req.a + req.b)


def callback(data):
    rospy.loginfo(rospy.get_caller_id() + "Data Received %s", data.data)


class master:

    def __init__(self):
        pub = rospy.Publisher('gps_track', os.path.basename('../utils/models/gpsTrack.py'), queue_size=10)

        rospy.init_node('master', anonymous=False)

        rospy.Subscriber("gps_location", String, callback)

        service_s = rospy.Service('CommandNet', CommandNet, commandNet)

        print(service_s)

        rate = rospy.Rate(0.2)  # 1hz

        while not rospy.is_shutdown():
            rospy.loginfo("master is live")
            pub.publish(commandNet)
            rate.sleep()

    pass
