#!/usr/bin/env python
import rospy
from std_msgs.msg import String
import os


def callback(data):
    rospy.loginfo(rospy.get_caller_id() + "Data Received %s", data.data)


def em_supervision():
    rospy.init_node('em_supervision', anonymous=False)
    rospy.Subscriber("gps_location", String, callback)
    rate = rospy.Rate(0.2)  # 1hz
    while not rospy.is_shutdown():
        rospy.loginfo("emergency supervision is live")
        rate.sleep()


if __name__ == '__main__':
    try:
        em_supervision()
    except rospy.ROSInterruptException:
        pass
