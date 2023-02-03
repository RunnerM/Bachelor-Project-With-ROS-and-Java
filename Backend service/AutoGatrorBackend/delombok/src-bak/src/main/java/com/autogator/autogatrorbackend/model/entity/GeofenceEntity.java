package com.autogator.autogatrorbackend.model.entity;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "geofence", schema = "ag")
public class GeofenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.geofence_id_seq")
    private Long id;

    @Column(name = "geofence_name", unique = true)
    private String geofenceName;

    @Column(name = "point_a_latitude")
    private float pointALatitude;

    @Column(name = "point_a_longitude")
    private float pointALongitude;

    @Column(name = "point_b_latitude")
    private float pointBLatitude;

    @Column(name = "point_b_longitude")
    private float pointBLongitude;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "geofence_id")
    @Builder.Default
    private List<GeofenceInternalBoundaryEntity> geofenceInternalBoundaries = new ArrayList<>();
}
