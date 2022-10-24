package com.autogator.autogatrorbackend.model;

import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Command {

    private Long id;

    private MachineCommand command;

    private CommandState commandState;

    private Timestamp timeIssued;
}
