package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.entity.CommandContextEntity;
import com.autogator.autogatrorbackend.model.entity.CommandEntity;
import com.autogator.autogatrorbackend.model.entity.MachineEntity;
import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.exception.CommandException;
import com.autogator.autogatrorbackend.model.request.CommandContextRequest;
import com.autogator.autogatrorbackend.model.response.CommandResponse;
import com.autogator.autogatrorbackend.repository.CommandContextRepository;
import com.autogator.autogatrorbackend.repository.CommandRepository;
import com.autogator.autogatrorbackend.repository.MachineRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandService {

    private final CommandRepository commandRepository;
    private final MachineRepository machineRepository;
    private final CommandContextRepository commandContextRepository;

    private final ModelMapper mapper = new ModelMapper();

    public Command queueCommand(CommandContextRequest commandContextRequest) {

        CommandEntity commandEntity = CommandEntity.builder()
                .commandState(CommandState.QUEUED)
                .timeIssued(Timestamp.valueOf(ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime()))
                .command(commandContextRequest.getMachineCommand())
                .machineEntity(getMachineEntity(commandContextRequest.getMachineSerialNumber()))
                .build();

        CommandEntity savedCommand = commandRepository.save(commandEntity);

        saveCommandContext(savedCommand, commandContextRequest.getAdditionalAttributes());

        return null;
    }
    public Command getNextCommand(String serialNumber) {

        if (commandRepository.findByCommandStateAndMachineEntity(CommandState.IN_PROGRESS, getMachineEntity(serialNumber)).isPresent()) {
            throw new CommandException("Another command is already in progress");
        }

        CommandEntity command = commandRepository
                .findFirstByCommandStateAndMachineEntityOrderByTimeIssuedAsc(CommandState.QUEUED, getMachineEntity(serialNumber))
                .orElseThrow(
                () -> {
                    throw new CommandException("There are no queued commands");
                });

        command.setCommandState(CommandState.IN_PROGRESS);
        commandRepository.save(command);

        CommandResponse commandResponse = createCommandResponse(command);

        return mapper.map(command, Command.class);

    }

    public Command finishCurrentCommand(String serialNumber) {

        CommandEntity commandEntity = commandRepository.findByCommandStateAndMachineEntity(CommandState.IN_PROGRESS, getMachineEntity(serialNumber))
                .orElseThrow(
                        () -> {
                            throw new CommandException("There are no commands in progress");
                        });

        commandEntity.setCommandState(CommandState.FINISHED);

        return mapper
                .map(commandRepository.save(commandEntity), Command.class);
    }

    private MachineEntity getMachineEntity(String serialNumber) {

        return machineRepository.findBySerialNumber(serialNumber).orElseThrow(() -> {
            throw new CommandException("Machine with serial number: " + serialNumber + "does not exist");
        });
    }

    private void saveCommandContext(CommandEntity commandEntity, Map<String, String> additionalAttributes) {

        for (Map.Entry<String, String> entry : additionalAttributes.entrySet()) {
            commandContextRepository.save(CommandContextEntity.builder().
                    commandEntity(commandEntity).
                    key(entry.getKey()).
                    value(entry.getValue()).
                    build());
        }

    }

    private CommandResponse createCommandResponse(CommandEntity commandEntity) {


        return null;
    }

}
