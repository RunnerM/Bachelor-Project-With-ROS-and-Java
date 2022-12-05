#!/usr/bin/env python
import rospy
from autogator.msg import Location, GpsTrackMsg, CmdReq, StartIrrigationRequest, EmStopRequest, DiagnosticStatus, DiagnosticArray
from autogator.models.gpsTrack import GpsTrack, GpsPoint


class MasterService:
    track = GpsTrack

    def __init__(self):
        self.tracking = False
        self.track = GpsTrack()
        self.seq = 1
        self.loc_pub = rospy.Publisher('location', Location, queue_size=10)
        self.track_pub = rospy.Publisher('gps_track', GpsTrackMsg, queue_size=10)
        self.irrigation_pub = rospy.Publisher('irrigation_command', StartIrrigationRequest, queue_size=10)
        self.emergency_stop_pub = rospy.Publisher('emergency_stop', EmStopRequest, queue_size=10)
        self.diagnostic_publisher = rospy.Publisher('/diagnostics', DiagnosticArray, queue_size=10)

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
        self.track.empty_track()
        self.seq += 1
        pass

    def handle_command(self, command):
        # handle cmd here and pass to proper func by type.
        # see what the boolean is
        command_type = command.type
        if command_type == "START_RECORDING":
            # rospy.loginfo("Start recording route")
            self.handle_start_recording_route()
        elif command_type == "STOP_RECORDING":
            # handle stop recording in diff func.
            # rospy.loginfo("stop recording route")
            self.handle_stop_recording_route()
        elif command_type == "START_IRRIGATION":
            # handle start self driving in diff func.
            self.handle_star_selfdriving(command)
            # rospy.loginfo("start self driving")
        elif command_type == "EMERGENCY_STOP":
            # handle emergency stop in diff func.
            em_stop_req = self.handle_em_stop_req()
            # rospy.loginfo("emergency stop")
        else:
            # rospy.loginfo("Invalid command")
            _diagnostic_status = self.create_status_msg("MASTER", "INVALID COMMAND")
            self.send_info(_diagnostic_status)

    def handle_em_stop_req(self):
        em_stop_req = EmStopRequest()
        em_stop_req.header.stamp = rospy.Time.now()
        em_stop_req.header.frame_id = "em_stop"
        em_stop_req.stop = True
        self.emergency_stop_pub.publish(em_stop_req)
        return em_stop_req

    def handle_star_selfdriving(self, command):
        start_irrigation_req = StartIrrigationRequest()
        start_irrigation_req.header.stamp = rospy.Time.now()
        start_irrigation_req.header.frame_id = "irrigation"
        start_irrigation_req.path = command.path
        self.irrigation_pub.publish(start_irrigation_req)

    pass

    def send_gps_track_to_networking(self, track):
        track_msg = GpsTrackMsg()
        track_msg.header.stamp = rospy.Time.now()
        track_msg.header.frame_id = "gps_track"
        track_msg.serialized = track
        self.track_pub.publish(track_msg)
    pass

    def handle_new_gps_location(self, location):
        # handle message from gps node on new location and add it to recording path
        if self.tracking:
            self.handle_new_point_to_route(location)
        # report to networking about location
        self.loc_pub.publish(location)

        pass

    def handle_stop_recording_route(self):
        self.tracking = False
        # send track to networking
        # map track to msg here
        serialized_track = self.track.to_json()

        self.send_gps_track_to_networking(serialized_track)
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
