import unittest

from src.autogator.src.autogator.models.geoFence import GeoFence, Obstacle
from src.autogator.src.autogator.models.gpsTrack import GpsPoint


def seed_data():
    fence = GeoFence()
    point_a = GpsPoint(-15.5, 20.3)
    point_c = GpsPoint(15.5, -20.3)
    fence.set_fence(point_a, point_c)
    return fence


class GeofenceTestCase(unittest.TestCase):
    def test_add_remove_obstacle(self):
        fence = seed_data()
        obs1 = Obstacle(GpsPoint(-5.6, 10.5), GpsPoint(0.2, 5.6))
        res = fence.add_obstacle(obs1)
        self.assertEqual(res, True)
        self.assertEqual(len(fence.obstacles), 1)
        fence.remove_obstacle(obs1)
        self.assertEqual(len(fence.obstacles), 0)

    def test_serialization(self):
        fence = seed_data()
        obs1 = Obstacle(GpsPoint(-5.6, 10.5), GpsPoint(0.2, 5.6))
        res = fence.add_obstacle(obs1)
        self.assertEqual(res, True)
        json_fence = fence.to_json()
        self.assertIsNotNone(json_fence)
        self.assertEqual(json_fence,
                         '{"obstacles": [{"a": {"latitude": 10.5, "longitude": -5.6}, "c": {"latitude": 5.6, "longitude": 0.2}}], "A": {"latitude": 20.3, "longitude": -15.5}, "C": {"latitude": -20.3, "longitude": 15.5}}')
        decoded_fence = GeoFence.from_json(json_fence)
        self.assertIsInstance(decoded_fence, GeoFence)
        self.assertEqual(fence.A.latitude, decoded_fence.A.latitude)
        self.assertEqual(fence.A.longitude, decoded_fence.A.longitude)
        self.assertEqual(fence.C.latitude, decoded_fence.C.latitude)
        self.assertEqual(fence.C.longitude, decoded_fence.C.longitude)
        self.assertEqual(len(fence.obstacles), len(decoded_fence.obstacles))
        self.assertEqual(fence.obstacles[0].a.latitude, decoded_fence.obstacles[0].a.latitude)

    def test_check_point_in_fence(self):
        fence = seed_data()
        obs1 = Obstacle(GpsPoint(-5.6, 10.5), GpsPoint(0.2, 5.6))
        res = fence.add_obstacle(obs1)
        self.assertEqual(res, True)
        point = GpsPoint(-1.5, 8.0)
        self.assertEqual(fence.check_point_in_fence(point), False)
        point = GpsPoint(-10.0, 8.0)
        self.assertEqual(fence.check_point_in_fence(point), True)
        point = GpsPoint(-1.5, 0.0)
        self.assertEqual(fence.check_point_in_fence(point), True)
        point = GpsPoint(-2, 9.0)
        self.assertEqual(fence.check_point_in_fence(point), False)
        point = GpsPoint(-20.9, 5.0)
        self.assertEqual(fence.check_point_in_fence(point), False)
        point = GpsPoint(-2.0, -30.5)
        self.assertEqual(fence.check_point_in_fence(point), False)

    def test_api_model_serialization(self):
        fence = seed_data()
        fence.name = "test"
        obs1 = Obstacle(GpsPoint(4.6, 10.5), GpsPoint(0.2, 5.6))
        res = fence.add_obstacle(obs1)
        self.assertEqual(res, True)
        api_fence = fence.to_api_model()
        self.assertIsNotNone(api_fence)
        decoded = GeoFence.from_api_model(api_fence)
        self.assertEqual(decoded.A.latitude, fence.A.latitude)
        self.assertEqual(decoded.A.longitude, fence.A.longitude)
        self.assertEqual(decoded.C.latitude, fence.C.latitude)
        self.assertEqual(decoded.C.longitude, fence.C.longitude)
        self.assertEqual(len(api_fence.obstacles), len(fence.obstacles))
        self.assertEqual(api_fence.obstacles[0].a.latitude, fence.obstacles[0].a.latitude)
        self.assertEqual(api_fence.obstacles[0].a.longitude, fence.obstacles[0].a.longitude)
        self.assertEqual(api_fence.obstacles[0].c.latitude, fence.obstacles[0].c.latitude)
        self.assertEqual(api_fence.obstacles[0].c.longitude, fence.obstacles[0].c.longitude)


if __name__ == '__main__':
    unittest.main()
