#!/usr/bin/env python
from __future__ import print_function

from autogator.srv import AddTwoInts, AddTwoIntsResponse

import rospy
from std_msgs.msg import String


# This will be later turned into proper function
# For now it's from the tutorial.
def handle_add_two_ints(req):
    print("Returning [%s + %s = %s]" % (req.a, req.b, (req.a + req.b)))
    return AddTwoIntsResponse(req.a + req.b)


def callback(data):
    rospy.loginfo(rospy.get_caller_id() + "Data Received %s", data.data)


def master():
    rospy.init_node('master', anonymous=True)
    # BPFC-13
    rospy.Subscriber("gps_data", String, callback)
    # That's for BPFC-12
    service_s = rospy.Service('add_two_ints', AddTwoInts, handle_add_two_ints())
    rate = rospy.Rate(0.2)  # 1hz

    # keeps code from exiting until the node is stopped
    # rospy.spin()

    while not rospy.is_shutdown():
        rospy.loginfo("master is live")
        rate.sleep()


if __name__ == '__main__':
    try:
        master()
    except rospy.ROSInterruptException:
        pass
