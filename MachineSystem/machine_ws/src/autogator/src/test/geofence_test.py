import unittest

from src.autogator.src.autogator.models.geoFence import GeoFence, Obstacle
from src.autogator.src.autogator.models.gpsTrack import GpsPoint


def seed_data():
    fence = GeoFence()
    point_a = GpsPoint(41.40000, 2.10000)
    point_c = GpsPoint(-41.40000, -2.10000)
    fence.set_fence(point_a, point_c)
    return fence


class GeofenceTestCase(unittest.TestCase):
    def test_add_remove_obstacle(self):
        fence = seed_data()
        obs1 = Obstacle(GpsPoint(40.30000, 1.10000), GpsPoint(-40.40000, -1.10000))
        res = fence.add_obstacle(obs1)
        self.assertEqual(res, True)
        self.assertEqual(len(fence.obstacles), 1)
        fence.remove_obstacle(obs1)
        self.assertEqual(len(fence.obstacles), 0)

    def test_serialization(self):
        fence = seed_data()
        obs1 = Obstacle(GpsPoint(40.30001, 1.10001), GpsPoint(-40.40001, -1.10001))
        res = fence.add_obstacle(obs1)
        self.assertEqual(res, True)
        json_fence = fence.to_json()
        self.assertIsNotNone(json_fence)
        self.assertEqual(json_fence, '{"obstacles": [{"a": {"latitude": 40.30001, "longitude": 1.10001}, '
                                     '"c": {"latitude": -40.40001, "longitude": -1.10001}}], "A": {"latitude": 41.4, '
                                     '"longitude": 2.1}, "C": {"latitude": -41.4, "longitude": -2.1}}')
        decoded_fence = GeoFence.from_json(json_fence)
        self.assertIsInstance(decoded_fence, GeoFence)
        self.assertEqual(fence.A.latitude, decoded_fence.A.latitude)
        self.assertEqual(fence.A.longitude, decoded_fence.A.longitude)
        self.assertEqual(fence.C.latitude, decoded_fence.C.latitude)
        self.assertEqual(fence.C.longitude, decoded_fence.C.longitude)
        self.assertEqual(len(fence.obstacles), len(decoded_fence.obstacles))
        self.assertEqual(fence.obstacles[0].a.latitude, decoded_fence.obstacles[0].a.latitude)


if __name__ == '__main__':
    unittest.main()
