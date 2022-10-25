package com.autogator.autogatrorbackend.repository;

import com.autogator.autogatrorbackend.model.entity.GeofenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface GeofenceRepository extends JpaRepository<GeofenceEntity, Long> {
    GeofenceEntity getGeofenceByGeofenceName(String geofenceName);

    @Query("SELECT ge.geofenceName FROM GeofenceEntity ge")
    List<String> getGeofenceNames();

    Integer removeByGeofenceName(String geofenceName);
}
