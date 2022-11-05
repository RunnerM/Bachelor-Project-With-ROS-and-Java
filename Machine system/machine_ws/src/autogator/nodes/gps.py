#!/usr/bin/env python
import rospy

from std_msgs.msg import String
from datetime import time


class gps_node:
    _time = time
    latitude = float
    longitude = float

    def __init__(self, _time=time, latitude=float, longitude=float):
        self._time = time
        self.latitude = latitude
        self.longitude = longitude

        pub = rospy.Publisher('gps_location', String, queue_size=10)
        rospy.init_node('gps_node', anonymous=True)
        gps_node_rate = rospy.Rate(0.2)

        rospy.get_time = time
        longitude += 1
        latitude += 2

        dummy_data_str = "Point: lat: %d and long: %d and the time is %s" % (latitude, longitude, time)
        rospy.loginfo(dummy_data_str)
        pub.publish(dummy_data_str)
        gps_node_rate.sleep()

        pass
