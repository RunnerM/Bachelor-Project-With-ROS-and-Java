#!/usr/bin/env python
import rospy
from std_msgs.msg import String
from datetime import time


def callback(data):
    rospy.loginfo(rospy.get_caller_id() + "Data Received %s", data.data)


class em_supervision:
    _time = time
    latitude = float
    longitude = float

    def __init__(self):
        rospy.init_node('em_supervision', anonymous=False)

        rospy.Subscriber("gps_location", String, callback)
        rate = rospy.Rate(0.2)

        while not rospy.is_shutdown():
            rospy.loginfo("emergency supervision is live")
            rate.sleep()

    pass
