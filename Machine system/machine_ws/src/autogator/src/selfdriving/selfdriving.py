#!/usr/bin/env python
import rospy
from std_msgs.msg import String
import http.client


def selfdriving():
    rospy.init_node('selfdriving')
    rate = rospy.Rate(0.2)  # 1hz
    while not rospy.is_shutdown():
        rospy.loginfo("self-driving is live")
        rate.sleep()


if __name__ == '__main__':
    try:
        selfdriving()
    except rospy.ROSInterruptException:
        pass
