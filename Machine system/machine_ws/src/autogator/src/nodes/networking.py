#!/usr/bin/env python
from __future__ import print_function
import sys
from _cffi_backend import string
import rospy
from std_msgs.msg import String

from machine_ws.src.autogator.src.utils.networking.autogatorClient import AutogatorClient
from machine_ws.src.autogator.srv import CommandNet
import os


def callback(data):
    rospy.loginfo(rospy.get_caller_id() + "Data Received %s", data.data)


def command_net_client(command_type, time, state):
    rospy.wait_for_service('CommandNet', 60)
    try:
        cmd_from_serv = rospy.ServiceProxy('CommandNet', CommandNet)
        response1 = cmd_from_serv(command_type, time, state)
        return response1.data
    except rospy.ServiceException as e:
        print("Service call failed: %s" % e)


def usage():
    return "%s [command_type time state]" % sys.argv[0]


class networking:

    def __init__(self):
        rospy.init_node('networking', anonymous=True)

        rospy.Subscriber("gps_location", os.path.basename('../utils/models/gpsTrack.py'), callback)
        rate = rospy.Rate(0.2)  # 1hz

        if len(sys.argv) == 4:
            command_type = string(sys.argv[1])
            time = string(sys.argv[2])
            state = string(sys.argv[3])
        else:
            print(usage())

        print("Requesting command: %s from %s with state: %s" % (command_type, time, state))
        print("%s , %s , %s" % (command_type, state, command_net_client(command_type, time, state)))
        while not rospy.is_shutdown():
            AutogatorClient.scan_for_command()
            rate.sleep()

    pass
