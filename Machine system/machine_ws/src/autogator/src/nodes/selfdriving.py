#!/usr/bin/env python
import rospy
from std_msgs.msg import String
import http.client
import os


def callback(data):
    rospy.loginfo(rospy.get_caller_id() + "Data Received %s", data.data)


def selfdriving():
    rospy.init_node('selfdriving', anonymous=False)
    rospy.Subscriber("gps_location", String, callback)
    rate = rospy.Rate(0.2)  # 1hz
    while not rospy.is_shutdown():
        rospy.loginfo("self-driving is live")
        rate.sleep()


if __name__ == '__main__':
    try:
        selfdriving()
    except rospy.ROSInterruptException:
        pass
