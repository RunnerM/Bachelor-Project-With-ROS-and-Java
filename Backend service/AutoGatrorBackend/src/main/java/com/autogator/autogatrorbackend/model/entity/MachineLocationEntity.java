package com.autogator.autogatrorbackend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "machine_location", schema = "ag")
public class MachineLocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.machine_location_id_seq")
    @SequenceGenerator(name = "ag.machine_location_id_seq")
    Long id;

    @Column(name = "location")
    private String machineLocation;

    @Column(name = "timestamp")
    private ZonedDateTime timestamp;

    @OneToOne
    MachineEntity machineEntity;

}
