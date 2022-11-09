#!/usr/bin/env python
from __future__ import print_function
from machine_ws.src.autogator.srv import CommandNet, CommandNetResponse
from std_msgs.msg import String
import os
import rospy

from autogator.msg import location
from autogator.services.masterService import MasterService
from autogator.utils.autogator_worker import AutogatorWorker


class master:

    def __init__(self):
        rospy.init_node('master', anonymous=False)

        # Callback should be in a service itself
        rospy.Subscriber("gps_location", location, MasterService.prepare_coordinates())
        rospy.logininfo("Master Started.")

        # Thread for publishing gps_track
        # Maybe update with another method
        publish_coord = AutogatorWorker("gps_location", function=MasterService.prepare_coordinates())
        publish_coord.start()

        # Handling of the service inside the service class
        service_s = rospy.Service('CommandNet', CommandNet, function=MasterService.handle_gpsTrack())

        # print(service_s)

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        master()
    except rospy.ROSInterruptException:
        pass
