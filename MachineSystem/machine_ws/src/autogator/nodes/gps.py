#!/usr/bin/env python
import rospy

from autogator.services.gpsService import GPSService
from autogator.utils.autogator_worker import AutogatorWorker
from autogator.msg import location


class gps_node:

    def __init__(self):
        rospy.init_node('gps_node', anonymous=False)
        rospy.loginfo("GPS Started.")
        # Thread
        generate_gps_coord = AutogatorWorker("gps_location", function=GPSService.get_gps_location())
        generate_gps_coord.start()

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        gps_node()
    except rospy.ROSInterruptException:
        pass
