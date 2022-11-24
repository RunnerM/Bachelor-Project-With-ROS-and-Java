#!/usr/bin/env python
import rospy
from autogator.msg import Location, StartIrrigationRequest
from autogator.services.selfdrivingService import SelfDrivingService


class selfdriving:

    def __init__(self):
        rospy.init_node('selfdriving', anonymous=False)
        sefldriving_service = SelfDrivingService()
        rospy.loginfo("Self-driving node started")
        # Callback for start irrigation
        rospy.Subscriber("irrigation_command", StartIrrigationRequest, sefldriving_service.start_irrigation)
        # Callback for new location
        rospy.Subscriber("gps_location", Location, sefldriving_service.handle_seldriving_location)

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        selfdriving()
    except rospy.ROSInterruptException:
        pass
