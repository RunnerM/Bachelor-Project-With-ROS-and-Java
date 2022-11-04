from src.autogator.src.utils.networking.autogatorClient import AutogatorClient
import rospy


class NetworkingService:

    def __init__(self):
        pass

    @staticmethod
    def scan_command():
        autogator_client = AutogatorClient()
        command = autogator_client.get_command()
        if command is not None:
            rospy.loginfo("Command received from backend: %s", command.to_json())

        else:
            rospy.loginfo("no command received")

    @staticmethod
    def post_track(gps_track):
        autogator_client = AutogatorClient()
        autogator_client.post_track(gps_track)

    def send_command_to_master(self, cmd_req):
        pub = rospy.Publisher('command', cmd_req, queue_size=10)
        pub.publish(cmd_req)
        pass
