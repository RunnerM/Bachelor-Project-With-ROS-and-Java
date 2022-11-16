#!/usr/bin/env python
import rospy
from autogator.msg import Location
from autogator.services.em_supervisionService import EmergencySupervisionService


class em_supervision:

    def __init__(self):
        rospy.init_node('em_supervision', anonymous=False)
        # Callback should be in a service itself
        rospy.Subscriber("gps_location", Location, EmergencySupervisionService.handle_emergency_situation)

        rospy.spin()

    pass

if __name__ == '__main__':
    try:
        em_supervision()
    except rospy.ROSInterruptException:
        pass