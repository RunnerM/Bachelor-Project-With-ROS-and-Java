#!/usr/bin/env python
import rospy
from std_msgs.msg import String

def callback(data):
    rospy.loginfo(rospy.get_caller_id() + "Data Received %s", data.data)

def master():
    rospy.init_node('master', anonymous=True)
    rospy.Subscriber("gps_data", String, callback)
    rate = rospy.Rate(0.2)  # 1hz

    # keeps code from exiting until the node is stopped
    #rospy.spin()

    while not rospy.is_shutdown():
        rospy.loginfo("master is live")
        rate.sleep()


if __name__ == '__main__':
    try:
        master()
    except rospy.ROSInterruptException:
        pass
