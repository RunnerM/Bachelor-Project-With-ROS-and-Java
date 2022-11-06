#!/usr/bin/env python
import rospy
import threading
from autogator.msg import gps_track, machine_state, location

from autogator.services.networkingService import NetworkingService
from autogator.utils.autogator_worker import AutogatorWorker


class networking:
    def __init__(self):
        rospy.init_node('networking')
        rospy.Subscriber("gps_track", gps_track, NetworkingService.upload_track)  # from master
        rospy.Subscriber("machine_state", machine_state, NetworkingService.upload_machinestate)  # from master
        rospy.Subscriber("location", location, NetworkingService.upload_location)  # from gps
        rospy.loginfo("Networking started.")
        # Starting worker thread so it doesn't block the main thread
        scan_command = AutogatorWorker("scan_command", function=NetworkingService.scan_command())
        scan_command.start()
        # threading.Thread(target=NetworkingService.scan_command()).start()

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        networking()
    except rospy.ROSInterruptException:
        pass
