#!/usr/bin/env python
import math
import string
import time

import rospy
from autogator.msg import SteeringCmd, MotorCmd, StartIrrigationRequest, EmStopResponse, MachineState
from simple_pid import PID
from autogator.models.gpsTrack import GpsTrack
from autogator.models.gpsTrack import GpsPoint
import geopy.distance as distance


class SelfDrivingService:

    def __init__(self):
        self.steering_pub = rospy.Publisher('steering_angle', SteeringCmd, queue_size=10)
        self.speed_pub = rospy.Publisher('motor_speed', MotorCmd, queue_size=10)
        self.machine_state_pub = rospy.Publisher('machine_state', MachineState, queue_size=10)
        # update every 5 seconds, 0.5 is the P value, 0.2 is the I value, 0 is the D value
        self.pid = PID(0.5, 0.2, 0, sample_time=5)
        self.pid.auto_mode = False
        self.current_track = GpsTrack()
        self.current_target_point = GpsPoint(0, 0)
        self.current_target_index = 0
        self.irrigation_in_progress = False
        pass

    def start_irrigation(self, start_irrigation_request):
        try:
            # Init track parameters here
            # deserialize track data from start_irrigation_request.path(JSON)
            rospy.loginfo("Starting irrigation")
            rospy.loginfo(start_irrigation_request.path)
            self.current_track = GpsTrack.from_json(start_irrigation_request.path)
            # Set first point in track as target point
            self.current_target_index = 0
            self.current_target_point = self.current_track.points[self.current_target_index]
            # Start driving forward here. location callback will take over
            self.send_steering_command(0)
            # Send speed command to motor node
            self.send_speed_command(0.5)
            # Set irrigation in progress to true so location callback will take over
            self.irrigation_in_progress = True
            # Start pid controller
            self.pid.auto_mode = True
            # signal irrigation started
            self.report_machine_state("ROLLING_OUT")
            rospy.loginfo("Started rollout")
        except Exception as e:
            self.signal_error("Error starting irrigation: " + str(e))
        pass

    def report_machine_state(self, state):
        machine_state = MachineState()
        machine_state.header.stamp = rospy.Time.now()
        machine_state.header.frame_id = "self_driving"
        machine_state.state = state
        self.machine_state_pub.publish(machine_state)

    def finalize(self):
        try:
            # exit from self-driving loop here. Reset all parameters
            self.irrigation_in_progress = False
            # stop pid controller
            self.pid.auto_mode = False
            self.report_machine_state("IRRIGATING")
            # start driving back to base here.
            # giving control to external node here we just wait three seconds for simulating the irrigation cycle
            time.sleep(3)
            self.report_machine_state("IDLE")

            rospy.loginfo("Finished rollout")
        except Exception as e:
            self.signal_error("Error finalizing irrigation: " + str(e))
        pass

    def handle_seldriving_location(self, location):
        # Check if irrigation is in progress
        if self.irrigation_in_progress:
            # Check for threshold on track point and if it is reached, send the next point
            point1 = (location.latitude, location.longitude)
            point2 = (self.current_target_point.latitude, self.current_target_point.longitude)
            if distance.distance(point1, point2).meters < 3:
                # Check if track is finished
                if self.current_target_index == len(self.current_track.points):
                    self.finalize()
                    pass
                else:
                    self.current_target_point = self.current_track.points[self.current_target_index + 1]
                    self.current_target_index += 1
                    # Recalculate optimal angle and set the setpoint here.
                    optimal_angle = self.calculate_optimal_angle(location, self.current_target_point)
                    self.pid.setpoint = optimal_angle
                pass
            control_value = self.pid(location.rotation)
            # Convert pid output to steering angle
            steering_angle = self.convert_gps_angle_to_steering_angle(control_value, location.rotation)
            # Send steering angle to steering node
            # Check if steering angle is in range
            if 30 > steering_angle > -30:
                self.send_steering_command(steering_angle)
            else:
                self.signal_error("Steering angle out of range")
            pass
        pass

    def handle_emergency_stop(self, stop_request):
        # stop irrigation here
        rospy.loginfo("Attempting emergency stop")
        if stop_request.stop and self.irrigation_in_progress:
            slef.signal_error("emergency stop")
            self.finalize()
            rospy.loginfo("Emergency stop is performed")
        pass

    # param: steering_angle = angle to turn the steering wheel
    def send_steering_command(self, steering_angle):
        steering_cmd = SteeringCmd()
        steering_cmd.target_angle = steering_angle
        self.steering_pub.publish(steering_cmd)
        pass

    # param: speed = speed to set the motor to
    def send_speed_command(self, speed):
        speed_cmd = MotorCmd()
        speed_cmd.target_speed = speed
        self.speed_pub.publish(speed_cmd)
        pass

    # param: current_location = current location of the vehicle
    # param: current_target_point = next point in track
    # return: optimal angle to turn the steering wheel
    # This function calculates the optimal angle to turn the steering wheel
    # The function does not take into account that the globe is a sphere
    # and therefore the angle has a tiny error of around 0.005%.
    def calculate_optimal_angle(self, location, current_target_point) -> float:
        # Calculate optimal angle from location and next point in track
        x = location.latitude - current_target_point.latitude
        y = location.longitude - current_target_point.longitude
        return math.atan2(y, x) * 180 / math.pi
        pass

    def convert_gps_angle_to_steering_angle(self, control_angle, current_angle) -> float:
        # Convert gps angle to steering angle
        # right is positive, left is negative in driving angle.
        return control_angle - current_angle
        pass

    def signal_error(self, error_message):
        # signal error here
        rospy.logerr(error_message)
        self.report_machine_state("ERROR")
        pass
