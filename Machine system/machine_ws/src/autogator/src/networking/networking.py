#!/usr/bin/env python
import rospy
from std_msgs.msg import String
import http.client


def networking():
    rospy.init_node('networking', anonymous=True)
    rate = rospy.Rate(0.2)  # 1hz
    while not rospy.is_shutdown():
        connection = http.client.HTTPSConnection("autogator-servcie.herokuapp.com")
        connection.request("GET", "/ros")
        response = connection.getresponse()
        hello_str = response.read().decode()
        rospy.loginfo(hello_str)
        rate.sleep()
        connection.close()


if __name__ == '__main__':
    try:
        networking()
    except rospy.ROSInterruptException:
        pass
