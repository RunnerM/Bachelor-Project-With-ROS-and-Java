#!/usr/bin/env python
import rospy
from std_msgs.msg import String


def master():
    rospy.init_node('master')
    rate = rospy.Rate(0.2)  # 1hz
    while not rospy.is_shutdown():
        rospy.loginfo("master is live")
        rate.sleep()


if __name__ == '__main__':
    try:
        master()
    except rospy.ROSInterruptException:
        pass
