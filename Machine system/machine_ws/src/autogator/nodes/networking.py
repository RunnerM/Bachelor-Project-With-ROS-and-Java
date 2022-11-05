#!/usr/bin/env python
import rospy
from autogator.msg import gps_track, machine_state, location

from autogator.services.networkingService import NetworkingService


class networking:
    def __init__(self):
        rospy.init_node('networking', anonymous=True)
        rospy.Subscriber("gps_track", gps_track, NetworkingService.upload_track)  # from master
        rospy.Subscriber("machine_state", machine_state, NetworkingService.upload_machinestate)  # from master
        rospy.Subscriber("location", location, NetworkingService.upload_location)  # from gps
        NetworkingService.scan_command()
        rospy.loginfo("networking is live and ready to receive data")

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        networking()
    except rospy.ROSInterruptException:
        pass
