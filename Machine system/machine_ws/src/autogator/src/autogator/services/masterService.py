#!/usr/bin/env python
import rospy
from autogator.msg import location, gps_track, cmd_req
from autogator.models.location import Location


class MasterService:

    def __init__(self):

        pass

    @staticmethod
    def handle_gps_track():
        # Handling of service
        # print("Returning [%s , %s , %s]" % (req.a, req.b, req.t))
        # resp = (req.a + req.b)
        # return resp
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

            MasterService.send_gps_track_to_networking(gps_track_msg)
        else:
            rospy.loginfo("Something went wrong")
        rate.sleep()

    @staticmethod
    def handle_new_point_to_route(condition):
        # handle message from gps node on new location and add it to recording path
        while condition:
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

                if gps_track_msg is not None:
                    MasterService.send_gps_track_to_networking(gps_track_msg)
        pass

    @staticmethod
    def handle_start_recording_route(command):
        condition_ = bool(True)
        if command is not None:
            if cmd_req.type == "START_REC":

                MasterService.handle_new_point_to_route(condition_)
            elif cmd_req.type == "STOP_REC":
                condition_ = bool(False)

        else:
            rospy.loginfo("Something went wrong")

        pass

    @staticmethod
    def handle_command(command):
        # handle cmd here and pass to proper func by type.
        # see what the boolean is
        command_type = cmd_req.type
        if command_type == "START_REC":
            rospy.loginfo("Current state : %s ,\n Success : %s", cmd_req.state, cmd_req.success)
            MasterService.handle_start_recording_route(cmd_req)
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
    def send_gps_track_to_networking(cls, location):
        pub = rospy.Publisher('location', location, queue_size=10)
        pub.publish(location)

    pass

    @classmethod
    def send_command_to_master(cls, cmd_req_):
        pub = rospy.Publisher('command_req', cmd_req_, queue_size=10)
        pub.publish(cmd_req_)

    pass
