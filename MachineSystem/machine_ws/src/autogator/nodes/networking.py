#!/usr/bin/env python
import rospy
import threading
from autogator.msg import GpsTrack, MachineState, Location

from autogator.services.networkingService import NetworkingService
from autogator.utils.autogator_worker import AutogatorWorker


class networking:
    def __init__(self):
        rospy.init_node('networking')
        self.networking_service = NetworkingService()
        rospy.Subscriber("gps_track", GpsTrack, self.networking_service.upload_track)  # from master
        rospy.Subscriber("machine_state", MachineState, self.networking_service.upload_machinestate)  # from master
        rospy.Subscriber("location", Location, self.networking_service.upload_location)  # from gps
        rospy.loginfo("Networking started.")
        scan_command = AutogatorWorker("scan_command", function=self.networking_service.scan_command())
        scan_command.start()
        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        networking()
    except rospy.ROSInterruptException:
        pass
