package com.autogator.autogatrorbackend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "geofence", schema = "ag")
public class GeofenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.geofence_id_seq")
    private Long id;

    @Column(name = "geofence_name", unique = true)
    private String geofenceName;

    @Column(name = "point_a")
    private float pointA;

    @Column(name = "point_b")
    private float pointB;

    @OneToMany(mappedBy = "geofence", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER, orphanRemoval = true)
    @Builder.Default
    private List<GeofenceInternalBoundaryEntity> geofenceInternalBoundaries = new ArrayList<>();
}
