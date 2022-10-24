package com.autogator.autogatrorbackend.model.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "geofence")
public class GeofenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "geofence_name")
    private String geofenceName;

    @Column(name = "point_a")
    private float pointA;

    @Column(name = "point_b")
    private float pointB;

    @OneToMany(mappedBy = "geofence")
    private Set<GeofenceInternalBoundaryEntity> geofence;
}
