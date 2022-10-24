package com.autogator.autogatrorbackend.model.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "geofence_internal_boundary")
public class GeofenceInternalBoundaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "point_a")
    private float pointA;

    @Column(name = "point_b")
    private float pointB;

    @ManyToOne
    private GeofenceEntity geofence;
}
