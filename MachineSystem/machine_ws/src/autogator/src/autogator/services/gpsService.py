#!/usr/bin/env python
import random
import rospy
from autogator.msg import Location, DiagnosticStatus, DiagnosticArray


class GPSService:

    def __init__(self):
        self.diagnostic_publisher = rospy.Publisher('/diagnostics', DiagnosticArray, queue_size=10)


        pass

    def get_gps_location(self):
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
                # rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", loc_msg.longitude, loc_msg.latitude,loc_msg.rotation)
                pub.publish(loc_msg)
                rate.sleep()
            else:

                _diagnostic_status = self.create_status_msg("GPS", "Can not read properly from GPS")
                self.send_info(_diagnostic_status)

        pass

    @staticmethod
    def create_status_msg(name, message):
        if name and message is not None:
            _diagnostic_status = DiagnosticStatus()
            _diagnostic_status.header.stamp = rospy.Time.Now()
            _diagnostic_status.name = name
            _diagnostic_status.message = message

        return _diagnostic_status

    def send_info(self, diagnostic_status):
        arr = DiagnosticArray()
        arr.header.stamp = rospy.Time.now()
        arr.status = [
            DiagnosticStatus(name=diagnostic_status.name, message=diagnostic_status.message)
        ]
        # publish
        self.diagnostic_publisher.publish(arr)
