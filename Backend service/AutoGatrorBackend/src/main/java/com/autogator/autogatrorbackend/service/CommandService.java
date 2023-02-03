package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.entity.CommandEntity;
import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.exception.CommandException;
import com.autogator.autogatrorbackend.model.request.CommandContextRequest;
import com.autogator.autogatrorbackend.model.response.CommandResponse;
import com.autogator.autogatrorbackend.repository.CommandContextRepository;
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
    private final CommandContextRepository commandContextRepository;
    private final MachineOwnershipService machineOwnershipService;
    private final CommandContextService commandContextService;
    private final MachineService machineService;

    private final ModelMapper mapper = new ModelMapper();

    public Command queueCommand(CommandContextRequest commandContextRequest) {

        //TODO: Take user id from auth service once implemented
        doesMachineBelongToUser(commandContextRequest.getMachineSerialNumber(), 1L);

        CommandEntity commandEntity = CommandEntity.builder()
                .commandState(CommandState.QUEUED)
                .timeIssued(Timestamp.valueOf(ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime()))
                .command(commandContextRequest.getMachineCommand())
                .MachineEntity(machineService.getMachineEntity(commandContextRequest.getMachineSerialNumber()))
                .build();

        CommandEntity savedCommandEntity = commandRepository.save(commandEntity);

        commandContextService.saveCommandContext(savedCommandEntity, commandContextRequest.getAdditionalAttributes());

        return mapper.map(savedCommandEntity, Command.class);
    }

    public CommandResponse getNextCommand(String machineSerialNumber) {

        //TODO: Take user id from auth service once implemented
        doesMachineBelongToUser(machineSerialNumber, 1L);

        if (commandRepository.findByCommandStateAndMachineEntity(CommandState.IN_PROGRESS,
                machineService.getMachineEntity(machineSerialNumber)).isPresent()) {
            throw new CommandException("Another command is already in progress");
        }

        CommandEntity CommandEntity = commandRepository
                .findFirstByCommandStateAndMachineEntityOrderByTimeIssuedAsc(CommandState.QUEUED,
                        machineService.getMachineEntity(machineSerialNumber))
                .orElseThrow(
                        () -> {
                            throw new CommandException("There are no queued commands for machine with serial number: " + machineSerialNumber);
                        });

        CommandEntity.setCommandState(CommandState.IN_PROGRESS);
        commandRepository.save(CommandEntity);

        CommandResponse commandResponse = commandContextService.createCommandResponse(commandContextRepository.findAllByCommandEntity(CommandEntity));
        commandResponse.setCommand(mapper.map(CommandEntity, Command.class));

        return commandResponse;

    }

    public Command finishCurrentCommand(String machineSerialNumber) {

        //TODO: Take user id from auth service once implemented
        doesMachineBelongToUser(machineSerialNumber, 1L);

        CommandEntity CommandEntity = commandRepository.findByCommandStateAndMachineEntity(CommandState.IN_PROGRESS,
                        machineService.getMachineEntity(machineSerialNumber))
                .orElseThrow(
                        () -> {
                            throw new CommandException("There are no commands in progress");
                        });

        commandContextRepository.removeByCommandEntity(CommandEntity);
        CommandEntity.setCommandState(CommandState.FINISHED);

        return mapper
                .map(commandRepository.save(CommandEntity), Command.class);
    }

    private void doesMachineBelongToUser(String machineSerialNumber, Long userId) {

        if(machineOwnershipService.doesMachineBelongToUser(machineSerialNumber, userId)) {
            throw new CommandException("Currently logged in user cannot issue commands to machine" + machineSerialNumber);
        }

    }
}
