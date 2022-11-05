#!/usr/bin/env python
import rospy
from std_msgs.msg import String


def callback(data):
    rospy.loginfo(rospy.get_caller_id() + "Data Received %s", data.data)


class selfdriving:

    def __init__(self):
        rospy.init_node('selfdriving', anonymous=False)

        rospy.Subscriber("gps_location", String, callback)
        rate = rospy.Rate(0.2)

        while not rospy.is_shutdown():
            rospy.loginfo("self-driving is live")
            rate.sleep()

    pass
