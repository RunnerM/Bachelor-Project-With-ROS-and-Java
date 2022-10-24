package com.autogator.autogatrorbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Geofence {

    private Long id;
    private String geofenceName;
    private float pointA;
    private float pointB;
    private Set<GeofenceInternalBoundary> geofenceInternalBoundaries;
}
