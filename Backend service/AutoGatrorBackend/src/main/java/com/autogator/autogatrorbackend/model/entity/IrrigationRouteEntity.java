package com.autogator.autogatrorbackend.model.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "irrigation_route")
public class IrrigationRouteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "route_name")
    private String routeName;

    @Column(name = "route_points")
    private String routePoints;
}
