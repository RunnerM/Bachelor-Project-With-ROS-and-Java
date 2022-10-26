package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.model.entity.GeofenceEntity;
import com.autogator.autogatrorbackend.repository.GeofenceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GeofenceService {

    ModelMapper mapper = new ModelMapper();

    @Autowired
    GeofenceRepository geofenceRepository;

    public Geofence saveRoute(Geofence geofence) {
        geofence.setId(null);

        return mapper.map(geofenceRepository.save(mapper.map(geofence, GeofenceEntity.class)), Geofence.class);
    }

    public Geofence getGeofence(String geofenceName) {
        return mapper.map(geofenceRepository.getGeofenceByGeofenceName(geofenceName), Geofence.class);
    }

    public List<String> getGeofenceNames() {
        return geofenceRepository.getGeofenceNames();
    }

    public Object removeGeofence(String geofenceName) {
        return geofenceRepository.removeByGeofenceName(geofenceName);
    }
}
