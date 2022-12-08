package com.autogator.autogatrorbackend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user", schema = "ag")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.user_id_seq")
    @SequenceGenerator(name = "ag.user_id_seq")
    Long id;

    @Column(name = "user_name")
    private String UserName;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<GeofenceEntity> geofenceEntityEntities;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<RouteEntity> irrigationRouteEntityEntities;

    @OneToMany
    List<MachineEntity> machineEntityList;

}
