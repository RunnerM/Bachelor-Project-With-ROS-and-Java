#!/usr/bin/env python
import rospy
from autogator.msg import location, gps_track, cmd_req
from autogator.models.location import Location


class MasterService:

    def __init__(self):

        pass

    @staticmethod
    def prepare_coordinates():
        # break this method down
        # preparing the cords for gpsTrack here
        rate = rospy.Rate(0.1)

        if location is not None:
            longitude = Location(location.longitude)
            latitude = Location(location.latitude)
            rotation = Location(location.rotation)
            rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", longitude, latitude, rotation)

            gps_track_msg = gps_track()
            record_no = 1
            gps_track_msg.name = "Track" + str(int(record_no + 1))

            loc_msg = location()
            loc_msg.longitude = longitude
            loc_msg.latitude = latitude
            loc_msg.rotation = rotation

            # Taking 10 readings
            for x in range(9):
                gps_track_msg.points[x] = loc_msg
                pass

                if gps_track_msg is not None:
                    MasterService.send_gps_track_to_networking(gps_track_msg)

            # handle sending the current location to networking for monitoring ("location" topic)

        else:
            rospy.loginfo("Something went wrong")
        rate.sleep()

    @staticmethod
    def handle_gps_track(req):
        # Handling of service
        print("Returning [%s , %s , %s]" % (req.a, req.b, req.t))
        resp = (req.a + req.b)
        return resp

    @staticmethod
    def handle_new_point_to_route(data):
        # handle message from gps node on new location and add it to recording path
        pass

    @staticmethod
    def handle_start_recording_route(command):
        # handle the start recording command
        # if it's start record, set bool to true
        pass

    @staticmethod
    def handle_command(command):
        # handle cmd here and pass to proper func by type.
        # see what the boolean is
        command_type = cmd_req.type
        if command_type == "START_REC":
            rospy.loginfo("Current state : %s ,\n Success : %s", cmd_req.state, cmd_req.success)
            # delegate the command to right function, in some cases self driving, we will send out messages for that node.
            # I dont think we need an extra round trip from ros.
            # MasterService.send_command_to_master(cmd_req)
        elif command_type == "STOP_REC":
            # handle stop recording in diff func.
            rospy.loginfo("Current state : %s ,\n Success : %s", cmd_req.state, cmd_req.success)
        elif command_type == "START_SELFDRIVE":
            # handle start self driving in diff func.
            rospy.loginfo("Current state : %s ,\n Success : %s", cmd_req.state, cmd_req.success)
        elif command_type == "EM_STOP":
            # handle emergency stop in diff func.
            rospy.loginfo("Current state : %s ,\n Success : %s", cmd_req.state, cmd_req.success)
        else:
            rospy.loginfo("Invalid command")

    pass

    @classmethod
    def send_gps_track_to_networking(cls, gps_track):
        pub = rospy.Publisher('gps_track', gps_track, queue_size=10)
        pub.publish(gps_track)

    pass

    @classmethod
    def send_command_to_master(cls, cmd_req_):
        pub = rospy.Publisher('command_req', cmd_req_, queue_size=10)
        pub.publish(cmd_req_)

    pass
