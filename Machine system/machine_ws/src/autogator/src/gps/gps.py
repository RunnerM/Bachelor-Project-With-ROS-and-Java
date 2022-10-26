#!/usr/bin/env python
import rospy
from std_msgs.msg import String

import os


# subscriber_listener=rospy.SubscribeListener can later be changed to correct
# instance and not dummy data one

def gps_node():
    pub = rospy.Publisher('gps_location', String, queue_size=10)
    # Anonymous is to give it a name that is not taken, in case gps_node is already used
    # somewhere else
    rospy.init_node('gps_node', anonymous=True)
    gps_node_rate = rospy.Rate(0.2)  # Keeping it 1hz?
    lat = 0
    long = 0

    while not rospy.is_shutdown():
        lat += 1
        long += 2
        dummy_data_str = "Point: lat: %d and long: %d and the time is %s" % (lat, long, rospy.get_time())
        rospy.loginfo(dummy_data_str)
        pub.publish(dummy_data_str)
        gps_node_rate.sleep()

    if __name__ == '__main__':
        try:
            gps_node()
        except rospy.ROSInterruptException:
            pass
