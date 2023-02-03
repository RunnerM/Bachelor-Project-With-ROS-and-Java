package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.model.entity.GeofenceEntity;
import com.autogator.autogatrorbackend.model.exception.GeofenceException;
import com.autogator.autogatrorbackend.repository.GeofenceRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class GeofenceService {

    private final ModelMapper mapper = new ModelMapper();

    private final GeofenceRepository geofenceRepository;

    public Geofence saveRoute(Geofence geofence) {
        geofence.setId(null);

        return mapper.map(geofenceRepository.save(mapper.map(geofence, GeofenceEntity.class)), Geofence.class);
    }

    public Geofence getGeofence(String geofenceName) {
        return mapper.map(geofenceRepository.getGeofenceByGeofenceName(geofenceName).orElseThrow(() -> {
            throw new GeofenceException("Geofence with name '" + geofenceName + "' does not exist");
        }), Geofence.class);
    }

    public List<String> getGeofenceNames() {
        return geofenceRepository.getGeofenceNames();
    }

    public Object removeGeofence(String geofenceName) {
        return geofenceRepository.removeByGeofenceName(geofenceName);
    }
}
