#!/usr/bin/env python
import math

import rospy
from autogator.msg import SteeringCmd, MotorCmd, StartIrrigationRequest, IrrigationState
from simple_pid import PID
from autogator.models.gpsTrack import GpsTrack
from autogator.models.gpsTrack import GpsPoint
import geopy.distance as distance


class SelfDrivingService:

    def __init__(self):
        self.steering_pub = rospy.Publisher('steering_angle', SteeringCmd, queue_size=10)
        self.speed_pub = rospy.Publisher('motor_speed', MotorCmd, queue_size=10)
        self.irrigation_state_pub = rospy.Publisher('irrigation_state', IrrigationState, queue_size=10)
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
            self.current_track = GpsTrack.from_json(start_irrigation_request.track)
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

            self.irrigation_state_pub.publish(IrrigationState("started"))
            rospy.loginfo("Started rollout")
        except Exception as e:
            self.signal_error("Error starting irrigation: " + str(e))
        pass

    def finalize(self):
        try:
            # exit from self-driving loop here. Reset all parameters
            self.irrigation_in_progress = False
            # stop pid controller
            self.pid.auto_mode = False
            self.signal_irrigation_finished()
            # start driving back to base here.
            # giving control to external node
            rospy.loginfo("Finished rollout")
        except Exception as e:
            self.signal_error("Error finalizing irrigation: " + str(e))
        pass

    def handle_seldriving_location(self, location):
        # Check if irrigation is in progress
        if not self.irrigation_in_progress:
            # Check for threshold on track point and if it is reached, send the next point
            if distance.distance(self.current_target_point, location).meters < 3:
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
            control_value = self.pid(location.angle)
            # Convert pid output to steering angle
            steering_angle = self.convert_gps_angle_to_steering_angle(control_value, location.angle)
            # Send steering angle to steering node
            # Check if steering angle is in range
            if 30 > steering_angle > -30:
                self.send_steering_command(steering_angle)
            else:
                self.signal_error("Steering angle out of range")
            pass
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

        pass

    def signal_irrigation_finished(self):

        pass
