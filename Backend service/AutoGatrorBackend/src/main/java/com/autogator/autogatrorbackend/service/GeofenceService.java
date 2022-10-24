package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.repository.GeofenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeofenceService {

    @Autowired
    GeofenceRepository geofenceRepository;

    public Geofence saveRoute(Geofence geofence) {
        return geofenceRepository.save(geofence);
    }

    public Geofence getGeofence(String geofenceName) {
        return geofenceRepository.getGeofenceByGeofenceName(geofenceName);
    }
}
