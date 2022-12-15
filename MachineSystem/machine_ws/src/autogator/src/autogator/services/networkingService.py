import string

from autogator.services.autogatorClient import AutogatorClient
import rospy
from autogator.models.machineState import MachineState
from autogator.models.gpsTrack import GpsPoint
from autogator.msg import CmdReq


class NetworkingService:

    def __init__(self):
        self.command_pub = rospy.Publisher('command', CmdReq, queue_size=10)

    def scan_command(self):
        autogator_client = AutogatorClient()
        rate = rospy.Rate(0.1)  # every 10 seconds
        while not rospy.is_shutdown():
            command, track, fence = autogator_client.get_command()
            if command is not None and command.command_type != "Default":
                rospy.loginfo("Command received from backend: %s", command.to_json())
                request = CmdReq()
                request.header.stamp = rospy.Time.now()
                request.header.frame_id = "command"
                request.header.seq = 1
                request.type = command.command_type
                if command.command_type == "START_IRRIGATION":
                    request.path = track.to_json()
                    request.geofence = fence.to_json()
                self.command_pub.publish(request)
            else:
                rospy.loginfo("No new command received.")
            rate.sleep()

    @staticmethod
    def upload_track(gps_track):
        autogator_client = AutogatorClient()

        res = autogator_client.post_track(gps_track)
        if res is True:
            rospy.loginfo("Track uploaded successfully.")
        else:
            rospy.loginfo("Track upload failed.")

    @staticmethod
    def upload_machinestate(machine_state):
        autogator_client = AutogatorClient()
        state_obj = MachineState(machine_state.state)
        rospy.loginfo("Requesting machine state update to: %s", state_obj.current_state)
        res = autogator_client.post_state(state_obj)
        if res is True:
            rospy.loginfo("Machine state uploaded successfully.")
        else:
            rospy.loginfo("Machine state upload failed.")

    @staticmethod
    def upload_location(location):
        autogator_client = AutogatorClient()
        location_point = GpsPoint(location.latitude, location.longitude)
        rospy.loginfo("Updating location to: %f, %f", location_point.latitude, location_point.longitude)
        res = autogator_client.post_location(location_point)
        if res is True:
            rospy.loginfo("Location uploaded successfully.")
        else:
            rospy.loginfo("Location upload failed.")
