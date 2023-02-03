package com.autogator.autogatrorbackend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "geofence_internal_boundary", schema = "ag")
public class GeofenceInternalBoundaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.geofence_internal_boundary_id_seq")
    @SequenceGenerator(name = "ag.geofence_internal_boundary_id_seq")
    private Long id;

    @Column(name = "point_a_latitude")
    private float pointALatitude;

    @Column(name = "point_a_longitude")
    private float pointALongitude;

    @Column(name = "point_b_latitude")
    private float pointBLatitude;

    @Column(name = "point_b_longitude")
    private float pointBLongitude;

    @Column(name = "geofence_id")
    private Long geofenceId;

    @ManyToOne
    GeofenceEntity GeofenceEntity;

}
