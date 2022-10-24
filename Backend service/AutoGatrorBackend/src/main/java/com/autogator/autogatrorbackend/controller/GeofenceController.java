package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.service.GeofenceService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/geofence")
public class GeofenceController {

  @Autowired GeofenceService geofenceService;

  @PostMapping
  public ResponseEntity<Geofence> insertGeofence(@NotNull @RequestBody Geofence geofence) {

    return ResponseEntity.ok(geofenceService.saveRoute(geofence));
  }

  @GetMapping
  public ResponseEntity<Geofence> getGeofence(@NotNull @RequestParam String geofenceName) {

    return ResponseEntity.ok(geofenceService.getGeofence(geofenceName));
  }
}
