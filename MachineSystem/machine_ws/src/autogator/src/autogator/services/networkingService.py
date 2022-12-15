import string

from autogator.services.autogatorClient import AutogatorClient
import rospy
from autogator.models.machineState import MachineState
from autogator.models.gpsTrack import GpsPoint
from autogator.msg import CmdReq
from autogator.msg import DiagnosticStatus, DiagnosticArray


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
                _diags = NetworkingService.create_status_msg("NETWORKING","NO NEW COMMAND RECEIVED")
                NetworkingService.send_info(_diags)
            rate.sleep()

    @staticmethod
    def upload_track(gps_track):
        autogator_client = AutogatorClient()

        res = autogator_client.post_track(gps_track)
        if res is True:
            rospy.loginfo("Track uploaded successfully.")
        else:
            rospy.loginfo("Track upload failed.")
            _diags = NetworkingService.create_status_msg("NETWORKING", "NO NEW COMMAND RECEIVED")
            NetworkingService.send_info(_diags)

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
            _diags = NetworkingService.create_status_msg("NETWORKING", "NO NEW COMMAND RECEIVED")
            NetworkingService.send_info(_diags)

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
            _diags = NetworkingService.create_status_msg("NETWORKING", "NO NEW COMMAND RECEIVED")
            NetworkingService.send_info(_diags)

    @classmethod
    def send_command_to_master(cls, cmd_req):
        pub = rospy.Publisher('command', cmd_req, queue_size=10)
        pub.publish(cmd_req)
        pass

    @staticmethod
    def create_status_msg(name, message):
        if name and message is not None:
            _diagnostic_status = DiagnosticStatus()
            _diagnostic_status.header.stamp = rospy.Time.Now()
            _diagnostic_status.name = name
            _diagnostic_status.message = message

        return _diagnostic_status

    @classmethod
    def send_info(cls, diagnostic_status):
        arr = DiagnosticArray()
        arr.header.stamp = rospy.Time.now()
        arr.status = [
            DiagnosticStatus(name=diagnostic_status.name, message=diagnostic_status.message)
        ]
        # publish
        diagnostic_publisher = rospy.Publisher('/diagnostics', DiagnosticArray, queue_size=10)
        diagnostic_publisher.publish(arr)
