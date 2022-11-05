#!#!/usr/bin/env python
import threading
import rospy


class AutogatorWorker(threading.Thread):
    def __init__(self, name, function):
        threading.Thread.__init__(self)
        self.name = name
        self.function = function

    def run(self):
        rospy.loginfo("Starting worker thread: " + self.name)
        self.function()
        rospy.loginfo("Exiting worker thread: " + self.name)
