#!/usr/bin/env python
import rospy
from autogator.models.geoFence import GeoFence
from autogator.models.gpsTrack import GpsPoint
from autogator.msg import EmStopRequest


class EmergencySupervisionService:

    def __init__(self):
        self.geofence = None
        self.emergency_stop_pub = rospy.Publisher("emergency_stop_req", EmStopRequest, queue_size=10)
        pass

    def check_location_emergency(self, location):
        point = GpsPoint(location.longitude, location.latitude)
        result = self.geofence.check_point_in_fence(point)
        if result:
            rospy.loginfo("Point is in geofence")
        else:
            self.emergency_stop_pub.publish(EmStopRequest("stop"))
            rospy.loginfo("Point is NOT in geofence")

    @staticmethod
    def handle_emergency_stop(location):
        # send stop request to selfdriving

        rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", location.longitude, location.latitude,
                      location.rotation)

        #

    def handle_geofence(self, geofence):
        self.geofence = GeoFence.from_json(geofence)
        rospy.loginfo("New geofence set")
