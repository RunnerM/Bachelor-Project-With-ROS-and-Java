package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.Geofence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface GeofenceRepository extends JpaRepository<Geofence, Long> {
    Geofence getGeofenceByGeofenceName(String geofenceName);
}
