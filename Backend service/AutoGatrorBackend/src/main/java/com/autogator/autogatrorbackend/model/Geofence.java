package com.autogator.autogatrorbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Geofence {

    private Long id;

    private String geofenceName;

    private float pointALatitude;

    private float pointALongitude;

    private float pointBLatitude;

    private float pointBLongitude;

    private List<GeofenceInternalBoundary> geofenceInternalBoundaries;
}
