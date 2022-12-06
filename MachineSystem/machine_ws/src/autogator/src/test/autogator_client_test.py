import unittest


from src.autogator.src.autogator.models.command import Command
from src.autogator.src.autogator.models.gpsTrack import GpsTrack, GpsPoint
from src.autogator.src.autogator.services.autogatorClient import AutogatorClient


class MyTestCase(unittest.TestCase):
    def test_get_command(self):
        client = AutogatorClient()
        command = client.get_command()
        self.assertIsNotNone(command)

    def test_post_command(self):
        client = AutogatorClient()
        command = Command("type", "time", "state")
        result = client.post_command(command)
        self.assertTrue(result)

    def test_post_track(self):
        client = AutogatorClient()
        track = GpsTrack("track_name_2")
        track.add_track_point(GpsPoint(1.2222, 2.3242))
        track.add_track_point(GpsPoint(1.2267, 2.3256))
        result = client.post_track(track)
        self.assertTrue(result)

    def test_post_location(self):
        client = AutogatorClient()
        result = client.post_location(GpsPoint(1.2222, 2.3242))
        self.assertTrue(result)


if __name__ == '__main__':
    unittest.main()
