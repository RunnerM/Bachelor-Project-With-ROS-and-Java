#!/usr/bin/env python
import rospy
from autogator.msg import SteeringCmd, MotorCmd, StartIrrigationRequest
from simple_pid import PID
from autogator.models.gpsTrack import GpsTrack
from autogator.models.gpsTrack import GpsPoint
import geopy.distance as distance


class SelfDrivingService:

    def __init__(self):
        self.steering_pub = rospy.Publisher('steering_angle', SteeringCmd, queue_size=10)
        self.speed_pub = rospy.Publisher('motor_speed', MotorCmd, queue_size=10)
        self.pid = PID(0, 0, 0, setpoint=0)
        self.current_track = GpsTrack()
        self.current_target_point = GpsPoint(0, 0)
        self.current_target_index = 0
        pass

    def start_irrigation(self, start_irrigation_request):
        # init track parameters here
        pass

    def finalize(self):
        # exit from self-driving loop here. Reset all parameters
        pass

    def handle_seldriving_location(self, location):
        # Check for threshold on track point and if it is reached, send the next point
        if distance.distance(self.current_target_point, location).meters < 3:
            self.current_target_point = self.current_track.points[self.current_target_index]
            self.current_target_index += 1
            pass
        # Calculate current optimal angle from location and next point in track
        optimal_angle = self.calculate_optimal_angle(location, self.current_target_point)
        # Convert gps angle to steering angle
        optimal_steering_angle = self.convert_gps_angle_to_steering_angle(optimal_angle)
        # set PID set point to optimal angle
        steering_angle = self.pid.setpoint = optimal_steering_angle

        current_steering_angle = self.pid(optimal_angle )
        # Send steering angle to steering node
        self.send_steering_command(current_steering_angle)
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

    def calculate_optimal_angle(self, location, current_target_point) -> float:
        # Calculate optimal angle from location and next point in track
        # return optimal_angle

        pass

    def handle_steering_feedback(self, steering_feedback):
        # Handle steering feedback here
        pass

    def convert_gps_angle_to_steering_angle(self, optimal_angle) -> float:
        # Convert gps angle to steering angle
        pass
