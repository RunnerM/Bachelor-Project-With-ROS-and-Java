import http.client
import rospy


class AutogatorClient:
    API_BASE_URL = "utogator-servcie.herokuapp.com"

    def __init__(self):
        pass

    def scan_for_command(self):
        connection = http.client.HTTPSConnection(self.API_BASE_URL)
        connection.request("GET", "/ros")
        response = connection.getresponse()
        hello_str = response.read().decode()
        rospy.loginfo(hello_str)
        connection.close()

    def send_track(self):
        connection = http.client.HTTPSConnection(self.API_BASE_URL)
        connection.request("POST", "/ros")
        response = connection.getresponse()
        hello_str = response.read().decode()
        rospy.loginfo(hello_str)
        connection.close()

