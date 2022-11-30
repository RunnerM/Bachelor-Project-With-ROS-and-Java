#!/usr/bin/env python
import rospy
from autogator.models.geoFence import GeoFence
from autogator.models.gpsTrack import GpsPoint
from autogator.msg import EmStopRequest, EmStopResponse
from datetime import datetime


class EmergencySupervisionService:

    def __init__(self):
        self.geofence = GeoFence(GpsPoint(0, 0), GpsPoint(0, 0))
        self.emergency_stop_pub = rospy.Publisher("emergency_stop_req", EmStopRequest, queue_size=10)

        pass

    def check_location_emergency(self, location):
        point = GpsPoint(location.longitude, location.latitude)
        rospy.loginfo("Checking location emergency: %s, %s", point.latitude, point.longitude)
        result = self.geofence.check_point_in_fence(point)
        if result:
            rospy.loginfo("Point is in geofence")
        else:
            stop_msg = EmStopRequest()
            stop_msg.header.stamp = rospy.Time.now()
            stop_msg.header.frame_id = "location"
            stop_msg.stop = True
            self.emergency_stop_pub.publish(stop_msg)
            rospy.loginfo("Point is NOT in geofence")

    def handle_emergency_stop(self, em_stop_req):
        # send stop request to selfdriving
        result = em_stop_req.stop
        if result:
            rospy.loginfo("Emergency break initiated.")
            stop_msg = EmStopRequest()
            stop_msg.header.stamp = rospy.Time.now()
            stop_msg.header.frame_id = "stop"
            stop_msg.stop = True
            self.emergency_stop_pub.publish(stop_msg)


    def handle_geofence(self, geofence):
        self.geofence = GeoFence.from_json(geofence)
        rospy.loginfo("New geofence set")
