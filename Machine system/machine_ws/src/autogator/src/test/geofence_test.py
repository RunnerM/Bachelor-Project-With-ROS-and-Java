import unittest

from src.autogator.src.utils.models.geoFence import GeoFence, Obstacle
from src.autogator.src.utils.models.gpsTrack import GpsPoint


def seed_data():
    fence = GeoFence()
    point_a = GpsPoint(41.40000, 2.10000)
    point_c = GpsPoint(-41.40000, -2.10000)
    fence.set_fence(point_a, point_c)
    return fence


class GeofenceTestCase(unittest.TestCase):
    def test_add_obstacle(self):
        fence = seed_data()
        obs1 = Obstacle(GpsPoint(40.30000, 1.10000), GpsPoint(-40.40000, -1.10000))
        fence.add_obstacle(obs1)
        self.assertEqual(len(fence.obstacles), 1)

    def test_remove(self):
        self.assertEqual(True, False)  # add assertion here

    def test_point_checking(self):
        self.assertEqual(True, False)  # add assertion here

    def test_serialization(self):
        self.assertEqual(True, False)  # add assertion here


if __name__ == '__main__':
    unittest.main()
