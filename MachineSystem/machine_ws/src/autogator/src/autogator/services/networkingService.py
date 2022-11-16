import string

from autogator.services.autogatorClient import AutogatorClient
import rospy
from autogator.models.machineState import MachineState
from autogator.models.gpsTrack import GpsPoint


class NetworkingService:

    def __init__(self):
        pass

    @staticmethod
    def scan_command():
        autogator_client = AutogatorClient()
        rate = rospy.Rate(0.1)  # every 10 seconds
        while not rospy.is_shutdown():
            command = autogator_client.get_command()
            if command is not None:
                rospy.loginfo("Command received from backend: %s", command.to_json())
                NetworkingService.send_command_to_master(command)
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

    @classmethod
    def send_command_to_master(cls, cmd_req):
        pub = rospy.Publisher('command', cmd_req, queue_size=10)
        pub.publish(cmd_req)
        pass
