package com.autogator.autogatrorbackend.model;

import com.autogator.autogatrorbackend.model.entity.GeofenceEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeofenceInternalBoundary {

    private Long id;

    private float pointA;

    private float pointB;

    private Long geoFenceId;
}
