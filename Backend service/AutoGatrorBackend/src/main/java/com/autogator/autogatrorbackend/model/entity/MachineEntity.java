package com.autogator.autogatrorbackend.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "machine", schema = "ag")
public class MachineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.machine_id_seq")
    @SequenceGenerator(name = "ag.machine_id_seq")
    private Long id;

    @Column(name = "serial_number", unique = true, nullable = false)
    private String serialNumber;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;

    @OneToMany(mappedBy="command")
    private Set<CommandEntity> commandEntities;

    @OneToMany(mappedBy="machineLocation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<MachineLocationEntity> machineLocationEntities;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private MachineStateEntity machineStateEntity;
}
