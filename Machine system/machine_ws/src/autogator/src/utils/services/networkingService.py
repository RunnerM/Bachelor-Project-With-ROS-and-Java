from src.autogator.src.utils.networking.autogatorClient import AutogatorClient
import rospy


class networkingService:

    def __init__(self):
        pass

    @staticmethod
    def scan_command():
        autogator_client = AutogatorClient()
