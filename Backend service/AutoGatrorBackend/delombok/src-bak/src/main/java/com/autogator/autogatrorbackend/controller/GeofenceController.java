package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.service.GeofenceService;
import com.sun.istack.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/geofence")
public class GeofenceController {
    //<editor-fold defaultstate="collapsed" desc="delombok">
    private final GeofenceService geofenceService;
    //</editor-fold>

    @PostMapping
    public ResponseEntity<Geofence> insertGeofence(@NotNull @RequestBody Geofence geofence) {
        return ResponseEntity.ok(geofenceService.saveRoute(geofence));
    }

    @GetMapping
    public ResponseEntity<Geofence> getGeofence(@NotNull @RequestParam String geofenceName) {
        return ResponseEntity.ok(geofenceService.getGeofence(geofenceName));
    }

    @GetMapping("/getNames")
    public ResponseEntity<List<String>> getGeofenceNames() {
        return ResponseEntity.ok(geofenceService.getGeofenceNames());
    }

    @DeleteMapping
    public ResponseEntity<Object> getGeofenceNames(@RequestParam String geofenceName) {
        return ResponseEntity.ok(geofenceService.removeGeofence(geofenceName));
    }

    @SuppressWarnings("all")
    public GeofenceController(final GeofenceService geofenceService) {
        this.geofenceService = geofenceService;
    }
}
