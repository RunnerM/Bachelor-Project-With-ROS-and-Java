package com.autogator.autogatrorbackend.model.entity;

import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
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
@Table(name = "command")
public class CommandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "machine_command")
    private MachineCommand command;

    @Column(name = "command_state")
    private CommandState commandState;

    @Column(name = "time_issued")
    private Timestamp timeIssued;

}
