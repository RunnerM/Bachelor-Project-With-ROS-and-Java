package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.entity.CommandEntity;
import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import com.autogator.autogatrorbackend.model.exception.CommandException;
import com.autogator.autogatrorbackend.repository.CommandRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandService {

    private final CommandRepository commandRepository;

    private final ModelMapper mapper = new ModelMapper();

    public Command queueCommand(MachineCommand machineCommand, String serialNumber) {

        CommandEntity commandEntity = CommandEntity.builder()
                .commandState(CommandState.QUEUED)
                .timeIssued(Timestamp.valueOf(ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime()))
                .command(machineCommand)
                .build();

        return mapper
                .map(commandRepository.save(commandEntity), Command.class);
    }
    public Command getNextCommand(String serialNumber) {

        if (commandRepository.findByCommandStateAndMachineSerialNumber(CommandState.IN_PROGRESS, serialNumber).isPresent()) {
            throw new CommandException("Another command is already in progress");
        }

        CommandEntity command = commandRepository
                .findFirstByCommandStateAndMachineSerialNumberOrderByTimeIssuedAsc(CommandState.QUEUED, serialNumber)
                .orElseThrow(
                () -> {
                    throw new CommandException("There are no queued commands");
                });

        command.setCommandState(CommandState.IN_PROGRESS);
        commandRepository.save(command);

        return mapper.map(command, Command.class);

    }

    public Command finishCurrentCommand(String serialNumber) {

        CommandEntity commandEntity = commandRepository.findByCommandStateAndMachineSerialNumber(CommandState.IN_PROGRESS, serialNumber)
                .orElseThrow(
                        () -> {
                            throw new CommandException("There are no commands in progress");
                        });

        commandEntity.setCommandState(CommandState.FINISHED);

        return mapper
                .map(commandRepository.save(commandEntity), Command.class);
    }
}
