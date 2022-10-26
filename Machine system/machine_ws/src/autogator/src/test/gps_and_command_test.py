#!/usr/bin/env python
import unittest

from src.autogator.src.utils.models.command import Command
from src.autogator.src.utils.models.gpsTrack import GpsTrack, GpsPoint


def seed_data():
    gt = GpsTrack("recording on field")
    point = GpsPoint(41.40338, 2.17403)
    point2 = GpsPoint(41.40333, 2.17402)
    gt.add_track_point(point)
    gt.add_track_point(point2)
    return gt


class GpsAndCommandTestCase(unittest.TestCase):

    def test_add_point(self):
        gt = seed_data()
        self.assertEqual(gt.points[0].latitude, 41.40338)
        self.assertEqual(gt.points[0].longitude, 2.17403)
        self.assertEqual(gt.points[1].latitude, 41.40333)
        self.assertEqual(gt.points[1].longitude, 2.17402)
        self.assertEqual(len(gt.points), 2)

    def test_remove_point(self):
        gt = seed_data()
        point_x = GpsPoint(1.32454, 33.24434)
        gt.add_track_point(point_x)
        self.assertEqual(len(gt.points), 3)
        gt.remove_point(point_x)
        self.assertEqual(len(gt.points), 2)
        self.assertEqual(gt.points[0].latitude, 41.40338)
        self.assertEqual(gt.points[0].longitude, 2.17403)
        self.assertEqual(gt.points[1].latitude, 41.40333)
        self.assertEqual(gt.points[1].longitude, 2.17402)

    def test_track_name(self):
        gt = seed_data()
        self.assertEqual("recording on field", gt.track_name)

    def test_serialization(self):
        gt = seed_data()
        json_gt = gt.to_json()
        self.assertIsNotNone(json_gt)
        self.assertEqual(json_gt,
                         '{"points": [{"latitude": 41.40338, "longitude": 2.17403}, {"latitude": 41.40333, "longitude": 2.17402}], "track_name": "recording on field"}')

    def test_command_serialization(self):
        command = Command("type", "time", "state")
        json_command = command.to_json()
        self.assertIsNotNone(json_command)
        self.assertEqual(json_command,
                         '{"command_type": "type", "time": "time", "state": "state"}')


if __name__ == '__main__':
    unittest.main()
