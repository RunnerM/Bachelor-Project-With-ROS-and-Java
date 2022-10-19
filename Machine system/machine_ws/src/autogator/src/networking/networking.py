#!/usr/bin/env python
from __future__ import print_function

import sys
import rospy
from std_msgs.msg import String
import http.client

from autogator.srv import *
from autogatorClient import AutogatorClient


# Handling communication between networking/master node through service
# As networking will be 'sending' cmds to master.
# cmds needs to be described in .srv files
def add_two_ints_client(x, y):
    rospy.wait_for_service('add_two_ints', 60)
    try:
        cmd_from_serv = rospy.ServiceProxy('add_two_ints', AddTwoInts)
        response1 = cmd_from_serv(x, y)
        return response1.sum
    except rospy.ServiceException as e:
        print("Service call failed: %s" % e)


def usage():
    return "%s [x y]" % sys.argv[0]


def networking():
    rospy.init_node('networking', anonymous=True)
    rate = rospy.Rate(0.2)  # 1hz
    if len(sys.argv) == 3:
        x = int(sys.argv[1])
        y = int(sys.argv[2])
    else:
        print(usage())
        sys.exit(1)
    print("Requesting %s+%s" % (x, y))
    print("%s + %s = %s" % (x, y, add_two_ints_client(x, y)))
    while not rospy.is_shutdown():
        AutogatorClient.scan_for_command()
        rate.sleep()


if __name__ == '__main__':
    try:
        networking()
    except rospy.ROSInterruptException:
        pass
