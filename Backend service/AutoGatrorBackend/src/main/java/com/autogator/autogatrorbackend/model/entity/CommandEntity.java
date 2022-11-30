package com.autogator.autogatrorbackend.model.entity;

import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "command", schema = "ag")
public class CommandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ag.command_id_seq")
    @SequenceGenerator(name = "ag.command_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private MachineEntity machineEntity;

    @Column(name = "machine_command")
    private MachineCommand command;

    @Column(name = "command_state")
    private CommandState commandState;

    @Column(name = "time_issued")
    private Timestamp timeIssued;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "command_id")
    private List<CommandContextEntity> contextEntityList;

}
