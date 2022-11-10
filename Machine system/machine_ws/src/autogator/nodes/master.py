#!/usr/bin/env python
from __future__ import print_function
import rospy

from autogator.msg import location, cmd_req
from autogator.services.masterService import MasterService
from autogator.utils.autogator_worker import AutogatorWorker


class master:

    def __init__(self):
        rospy.init_node('master', anonymous=False)

        # Callback should be in a service itself
        self.master_service = MasterService()
        rospy.Subscriber("gps_location", location, self.master_service.prepare_coordinates)
        rospy.Subscriber("command", cmd_req, self.master_service.handle_command)
        # rospy.Subscriber("command_req", cmd_req, self.master_service.handle_start_recording_route(cmd_req.success))
        rospy.loginfo("Master Started.")
        # Thread for publishing gps_track
        # Maybe update with another method
        publish_coord = AutogatorWorker("gps_location", function=self.master_service.prepare_coordinates(location))
        publish_coord.start()

        rospy.spin()

    pass


if __name__ == '__main__':
    try:
        master()
    except rospy.ROSInterruptException:
        pass
