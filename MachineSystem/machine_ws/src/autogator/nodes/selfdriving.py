#!/usr/bin/env python
import rospy
from autogator.msg import Location
from autogator.services.selfdrivingService import SelfDrivingService


class selfdriving:

    def __init__(self):
        rospy.init_node('selfdriving', anonymous=False)
        # Callback should be in a service itself
        rospy.Subscriber("gps_location", Location, SelfDrivingService.handle_seldriving_location)

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        selfdriving()
    except rospy.ROSInterruptException:
        pass
