#!#!/usr/bin/env python
import threading
import rospy


class AutogatorWorker(threading.Thread):
    def __init__(self, name, function):
        threading.Thread.__init__(self)
        self.name = name
        self.function = function

    def run(self):
        rospy.loginfo("Starting worker process")
        self.function()
        rospy.loginfo("Exiting worker process")

