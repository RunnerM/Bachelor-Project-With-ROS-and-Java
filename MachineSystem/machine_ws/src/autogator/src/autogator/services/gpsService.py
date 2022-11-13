#!/usr/bin/env python
import random
import rospy
from autogator.msg import Location

from rostest import deprecated


class GPSService:

    def __init__(self):

        pass

    @staticmethod
    def get_gps_location():
        lat = float
        long = float
        rot = float
        rate = rospy.Rate(0.1)
        pub = rospy.Publisher('gps_location', Location, queue_size=10)
        while not rospy.is_shutdown():
            # lat -90+90 / long -180+180
            long = random.randrange(-180, 181, 2)
            lat = random.randrange(-90, 91, 1)
            rot = random.randrange(-90, 91, 1)

            loc_msg = Location()
            loc_msg.header.stamp = rospy.Time.now()
            loc_msg.header.frame_id = "location"
            loc_msg.longitude = long
            loc_msg.latitude = lat
            loc_msg.rotation = rot

            if loc_msg is not None:
                rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", loc_msg.longitude, loc_msg.latitude,
                              loc_msg.rotation)
                # GPSService.send_loc_to_gps(loc_msg)
                pub.publish(loc_msg)
                rate.sleep()
            else:
                rospy.loginfo("Something went wrong")
                rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", loc_msg.longitude, loc_msg.latitude,
                              loc_msg.rotation)
                rate.sleep()
        pass

# deprecated this publisher should be created once.
    @staticmethod
    @deprecated
    def send_loc_to_gps(location):
        pub = rospy.Publisher('gps_location', location, queue_size=10)
        pub.publish(location)

    pass
