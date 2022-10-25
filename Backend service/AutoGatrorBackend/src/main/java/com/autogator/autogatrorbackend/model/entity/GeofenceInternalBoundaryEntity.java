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

    @Column(name = "point_a")
    private float pointA;

    @Column(name = "point_b")
    private float pointB;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "geofence_id")
    private GeofenceEntity geofence;
}
