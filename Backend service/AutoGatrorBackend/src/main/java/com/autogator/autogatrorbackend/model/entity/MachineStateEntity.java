package com.autogator.autogatrorbackend.model.entity;

import com.autogator.autogatrorbackend.model.enums.MachineStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "machine_state", schema = "ag")
public class MachineStateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.machine_state_id_seq")
    @SequenceGenerator(name = "ag.machine_state_id_seq")
    Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "machine_id")
    private MachineEntity machineEntity;

    @Column(name = "state", unique = true, nullable = false)
    private MachineStateEnum machineStateEnum;
}
