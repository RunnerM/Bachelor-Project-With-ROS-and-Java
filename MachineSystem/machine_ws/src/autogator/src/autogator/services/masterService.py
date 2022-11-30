#!/usr/bin/env python
import rospy
from autogator.msg import Location, GpsTrackMsg, CmdReq, StartIrrigationRequest
from autogator.models.gpsTrack import GpsTrack, GpsPoint


class MasterService:

    def __init__(self):
        self.tracking = False
        self.track = GpsTrack()
        self.seq = 1
        self.loc_pub = rospy.Publisher('location', Location, queue_size=10)
        self.track_pub = rospy.Publisher('gps_track', GpsTrackMsg, queue_size=10)
        self.irrigation_pub = rospy.Publisher('irrigation_command', StartIrrigationRequest, queue_size=10)

    def handle_new_point_to_route(self, location):
        # handle message from gps node on new location and add it to recording path
        if location is not None:
            point = GpsPoint(location.longitude, location.latitude)
            self.track.add_track_point(point)

    def handle_start_recording_route(self):
        # set global variable to true
        self.tracking = True
        # add name here.
        self.track = GpsTrack("track" + str(self.seq))
        self.seq += 1
        pass

    def handle_command(self, command):
        # handle cmd here and pass to proper func by type.
        # see what the boolean is
        command_type = command.type
        if command_type == "START_REC":
            rospy.loginfo("Current state : %s ,\n Success : %s", command.state, command.success)
            self.handle_start_recording_route()
        elif command_type == "STOP_REC":
            # handle stop recording in diff func.
            rospy.loginfo("Current state : %s ,\n Success : %s", command.state, command.success)
            self.handle_stop_recording_route()
        elif command_type == "START_SELFDRIVE":
            # handle start self driving in diff func.
            start_irrigation_req = StartIrrigationRequest()
            start_irrigation_req.header.stamp = rospy.Time.now()
            start_irrigation_req.header.frame_id = "location"
            start_irrigation_req.path = command.path
            self.irrigation_pub.publish(start_irrigation_req)
            rospy.loginfo("Current state : %s ,\n Success : %s", command.state, command.success)
        elif command_type == "EM_STOP":
            # handle emergency stop in diff func.
            rospy.loginfo("Current state : %s ,\n Success : %s", command.state, command.success)
        else:
            rospy.loginfo("Invalid command")

    pass

    def send_gps_track_to_networking(self, track_msg):
        self.track_pub.publish(track_msg)

    pass

    def handle_new_gps_location(self, location):
        # handle message from gps node on new location and add it to recording path
        rospy.loginfo("Coordinates: \nlong: %d,\nlat: %d,\nrot: %d", location.longitude, location.latitude,
                      location.rotation)
        if self.tracking:
            self.handle_new_point_to_route(location)

        # report to networking about location
        self.loc_pub.publish(location)

        pass

    def handle_stop_recording_route(self):
        self.tracking = False
        # send track to networking
        # map track to msg here

        MasterService.send_gps_track_to_networking(self.track)
        pass
