from autogator.services.autogatorClient import AutogatorClient
import rospy


class NetworkingService:

    def __init__(self):
        pass

    @staticmethod
    def scan_command():
        autogator_client = AutogatorClient()
        rate = rospy.Rate(0.1)  # every 10 seconds
        # this fetch control needs to brought up to node leve since it's blocking the thread
        while not rospy.is_shutdown():
            command = autogator_client.get_command()
            if command is not None:
                rospy.loginfo("Command received from backend: %s", command.to_json())
                NetworkingService.send_command_to_master(command)
            else:
                rospy.loginfo("No new command received.")
            rate.sleep()

    @classmethod
    def upload_track(cls, gps_track):
        autogator_client = AutogatorClient()

        res = autogator_client.post_track(gps_track)
        if res is True:
            rospy.loginfo("Track uploaded successfully.")
        else:
            rospy.loginfo("Track upload failed.")

    @classmethod
    def upload_machinestate(cls, machine_state):
        autogator_client = AutogatorClient()
        # Add object mapping here to convert machine_state to MachineState object
        res = autogator_client.post_state(machine_state)
        if res is True:
            rospy.loginfo("Track uploaded successfully.")
        else:
            rospy.loginfo("Track upload failed.")

    @classmethod
    def upload_location(cls, location):
        autogator_client = AutogatorClient()
        # Add object mapping here to convert location to Location object
        res = autogator_client.post_location(location)
        if res is True:
            rospy.loginfo("Location uploaded successfully.")
        else:
            rospy.loginfo("Location upload failed.")

    @classmethod
    def send_command_to_master(cls, cmd_req):
        pub = rospy.Publisher('command', cmd_req, queue_size=10)
        pub.publish(cmd_req)
        pass
