package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.entity.CommandEntity;
import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import com.autogator.autogatrorbackend.repository.CommandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
public class CommandService {

    @Autowired
    CommandRepository commandRepository;

    ModelMapper mapper = new ModelMapper();

    public Command queueCommand(MachineCommand machineCommand) {

        CommandEntity commandEntity = CommandEntity.builder()
                .commandState(CommandState.QUEUED)
                .timeIssued(Timestamp.valueOf(ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime()))
                .command(machineCommand)
                .build();

        return mapper
                .map(commandRepository.save(commandEntity), Command.class);
    }
    public Command getNextCommand() throws Exception {

        commandRepository.findByCommandState(CommandState.IN_PROGRESS).orElseThrow(Exception::new);

        CommandEntity command = commandRepository
                .findFirstByCommandStateOrderByTimeIssuedAsc(CommandState.QUEUED)
                .orElseThrow(Exception::new);

        command.setCommandState(CommandState.IN_PROGRESS);
        commandRepository.save(command);

        return mapper.map(command, Command.class);
    }

    public Command finishCurrentCommand() throws Exception {

        CommandEntity commandEntity = commandRepository.findByCommandState(CommandState.IN_PROGRESS).orElseThrow(Exception::new);

        commandEntity.setCommandState(CommandState.FINISHED);

        return mapper
                .map(commandRepository.save(commandEntity), Command.class);
    }
}
