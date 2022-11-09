#!/usr/bin/env python
import rospy
from autogator.msg import location , gps_track
from autogator.models.location import Location


class MasterService:

    def __init__(self):
        pass

    @staticmethod
    def prepare_coordinates(location_):
        # prepare the cords for gpsTrack here
        rate = rospy.Rate(0.1)

        if location_ is not None:
            longitude = Location(location_.longitude)
            latitude = Location(location_.latitude)
            rotation = Location(location_.rotation)
            rospy.logininfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", longitude, latitude, rotation)

            gps_track_msg = gps_track()
            record_no = 1
            gps_track_msg.name = "Track" + str(int(record_no+1))

            loc_msg = location()
            loc_msg.longitude = longitude
            loc_msg.latitude = latitude
            loc_msg.rotation = rotation

            for x in range(9):
                gps_track_msg.points[x] = loc_msg
                pass

                if gps_track_msg is not None:
                    MasterService.send_gpsTrack_to_master(gps_track_msg)
        else:
            rospy.logininfo("Something went wrong")
        rate.sleep()

    @staticmethod
    def handle_gpsTrack(req):
        # Handling of service
        print("Returning [%s , %s , %s]" % (req.a, req.b, req.t))
        resp = (req.a + req.b)
        return resp

        pass

    @classmethod
    def send_gpsTrack_to_master(cls, CommandNet):
        pub = rospy.Publisher('gps_track', CommandNet, queue_size=10)
        pub.publish(CommandNet)

    pass
