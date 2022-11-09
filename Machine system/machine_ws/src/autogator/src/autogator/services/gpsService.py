#!/usr/bin/env python
import random
import rospy
from autogator.msg import location


class GPSService:

    def __init__(self):

        pass

    @staticmethod
    def get_gps_location():
        lat = float
        long = float
        rot = float
        rate = rospy.Rate(0.1)
        while not rospy.is_shutdown():
            # lat -90+90 / long -180+180
            long = random.randrange(-180, 181, 2)
            lat = random.randrange(-90, 91, 1)
            rot = random.randrange(-90, 91, 1)

            rospy.logininfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", long, lat, rot)

            loc_msg = location()
            loc_msg.longitude = long
            loc_msg.latitude = lat
            loc_msg.rotation = rot

            if loc_msg is not None:
                rospy.logininfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", loc_msg.longitude, loc_msg.latitude, loc_msg.rotation)
                GPSService.send_loc_to_gps(loc_msg)
            else:
                rospy.logininfo("Something went wrong")
                rospy.logininfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", loc_msg.longitude, loc_msg.latitude, loc_msg.rotation)
                rate.sleep()
        pass

    @classmethod
    def send_loc_to_gps(cls, location):
        pub = rospy.Publisher('gps_location', location, queue_size=10)
        pub.publish(location)

    pass
