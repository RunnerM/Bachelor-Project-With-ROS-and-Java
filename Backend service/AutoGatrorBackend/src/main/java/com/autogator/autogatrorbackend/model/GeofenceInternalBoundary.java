package com.autogator.autogatrorbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeofenceInternalBoundary {

    private Long id;

    private float pointALatitude;

    private float pointALongitude;

    private float pointBLatitude;

    private float pointBLongitude;

    private Long geofenceId;
}
