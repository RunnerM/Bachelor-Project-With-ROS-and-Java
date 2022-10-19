#!/usr/bin/env python
import json
import unittest

from src.autogator.src.networking.models.gpsTrack import GpsTrack, GpsTrackPoint


class MyTestCase(unittest.TestCase):
    def test_model_serialization(self):
        gt = GpsTrack("recording on field")
        point = GpsTrackPoint(41.40338, 2.17403)
        point2 = GpsTrackPoint(41.40333, 2.17402)
        gt.add_track_point(point)
        gt.add_track_point(point2)
        self.assertEqual("recording on field", gt.track_name)
        print(gt.points[1].longitude, gt.points[1].latitude)
        print(gt.points[2].longitude, gt.points[2].latitude)
        # print(json.dumps(gt))
        print(gt.to_json())
        print(gt.track_name)


if __name__ == '__main__':
    unittest.main()
