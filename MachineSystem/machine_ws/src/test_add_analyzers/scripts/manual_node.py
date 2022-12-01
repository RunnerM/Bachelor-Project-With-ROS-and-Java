#!/usr/bin/env python

import rospy
import rosparam
from bondpy import bondpy
from autogator.msg import DiagnosticArray, DiagnosticStatus
from autogator.srv import AddDiagnostics


class ManualNode(object):

    def __init__(self):
        rospy.init_node('manual')
        rospy.on_shutdown(self.shutdown)
        # Load yaml parameters from a file, and load them into the parameter server
        # under this node's namespace.
        paramlist = rosparam.load_file(rospy.get_param('~analyzer_yaml'))
        for params, ns in paramlist:
            rosparam.upload_params(rospy.get_name() + '/' + ns, params)

        # Can use any namespace into which the parameters that we want to use to
        # specify analyzers have been loaded
        self.namespace = rospy.get_name()

    def start(self):

        # Create a bond to try and connect to the diagnostics aggregator. The second
        # parameter to the bond is the name of the bond. This name should be the
        # same as the load_namespace below
        self.bond = bondpy.Bond("/diagnostics_agg/bond", rospy.resolve_name(self.namespace))

        # Start the bond, initialising the connection and creating the analyzers
        # that were defined by the parameters loaded earlier
        self.bond.start()

        # To start the other side of the bond in the diagnostic aggregator, we must
        # send request via the add_diagnostics service. Once a service message is
        # received, the bond will form, and the analyzers will be added to the
        # aggregator.
        rospy.wait_for_service('/diagnostics_agg/add_diagnostics', timeout=10)
        add_diagnostics = rospy.ServiceProxy('/diagnostics_agg/add_diagnostics', AddDiagnostics)

        # The response indicates whether setup was successful or not. If the
        # namespace given is the same as a namespace that was sent previously, the
        # analyzers will not be added.
        resp = add_diagnostics(load_namespace=self.namespace)

        rate = rospy.Rate(1)
        while not rospy.is_shutdown():
            rate.sleep()

    def shutdown(self):
        # Make sure the bond is shut down once you're done. If it is not shut down
        # manually, the other side of the bond will automatically shut down after a
        # short time (~5 seconds), removing the analyzers from the aggregator.
        self.bond.shutdown()


if __name__ == '__main__':
    m = ManualNode()
    m.start()