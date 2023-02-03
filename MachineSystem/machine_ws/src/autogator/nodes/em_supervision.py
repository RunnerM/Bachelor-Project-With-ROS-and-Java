#!/usr/bin/env python
import rospy
from autogator.msg import Location
from autogator.msg import EmStopRequest
from autogator.services.em_supervisionService import EmergencySupervisionService


class em_supervision:

    def __init__(self):
        rospy.init_node('em_supervision', anonymous=False)
        self.emergency_supervision_service = EmergencySupervisionService()
        # Callback should be in a service itself
        rospy.Subscriber("gps_location", Location, self.emergency_supervision_service.check_location_emergency)
        rospy.Subscriber("emergency_stop", EmStopRequest, self.emergency_supervision_service.handle_emergency_stop)
        rospy.Subscriber("geofence", Location, self.emergency_supervision_service.handle_geofence)

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        em_supervision()
    except rospy.ROSInterruptException:
        pass
