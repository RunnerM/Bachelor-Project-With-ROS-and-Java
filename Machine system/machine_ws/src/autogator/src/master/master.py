#!/usr/bin/env python
from __future__ import print_function

from autogator.srv import CommandNet, CommandNetResponse

import rospy
from std_msgs.msg import String
import os


# This will be later turned into proper function
# For now it's from the tutorial.
def commandNet(req):
    #Not sure how to pass arguments when using this method
    print("Returning [%s , %s , %s]" % (req.a, req.b, req.t))
    return CommandNetResponse(req.a + req.b)


def callback(data):
    rospy.loginfo(rospy.get_caller_id() + "Data Received %s", data.data)


def master():
    pub = rospy.Publisher('gps_track', os.path.basename('../utils/models/gpsTrack.py'), queue_size=10)
    rospy.init_node('master', anonymous=False)
    # BPFC-13
    rospy.Subscriber("gps_location", String, callback)
    # That's for BPFC-12
    service_s = rospy.Service('CommandNet', CommandNet, commandNet)
    rate = rospy.Rate(0.2)  # 1hz

    # keeps code from exiting until the node is stopped
    # rospy.spin()

    while not rospy.is_shutdown():
        rospy.loginfo("master is live")
        pub.publish(commandNet)
        rate.sleep()


if __name__ == '__main__':
    try:
        master()
    except rospy.ROSInterruptException:
        pass
