import string
import json


class GpsTrackPoint(object):
    latitude = float
    longitude = float

    def __init__(self, longitude, latitude):
        self.latitude = latitude
        self.longitude = longitude
        pass


class GpsTrack(object):
    track_name = string
    points = {GpsTrackPoint}

    def __init__(self, track_name=string):
        self.points = {GpsTrackPoint}
        self.track_name = track_name
        pass

    def add_track_point(self, track_point=GpsTrackPoint):
        self.points.add(track_point)
        return

    def remove_last_point(self, track_point=GpsTrackPoint):
        self.points.remove(track_point)

    def to_json(self):
        return json.dumps(self)
