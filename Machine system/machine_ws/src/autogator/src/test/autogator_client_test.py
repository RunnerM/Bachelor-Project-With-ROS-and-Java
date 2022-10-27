import unittest

from src.autogator.src.networking.autogatorClient import AutogatorClient
from src.autogator.src.utils.models.command import Command
from src.autogator.src.utils.models.gpsTrack import GpsTrack


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
        track = GpsTrack("track_name")
        result = client.post_track(track)
        self.assertTrue(result)


if __name__ == '__main__':
    unittest.main()
