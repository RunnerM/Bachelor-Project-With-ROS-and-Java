package com.autogator.autogatrorbackend.model.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "route", schema = "ag")
public class IrrigationRouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.route_id_seq")
    @SequenceGenerator(name = "ag.route_id_seq")
    private Long id;

    @Column(name = "route_name", unique = true)
    private String routeName;

    @Column(name = "route_points")
    private String routePoints;
}
