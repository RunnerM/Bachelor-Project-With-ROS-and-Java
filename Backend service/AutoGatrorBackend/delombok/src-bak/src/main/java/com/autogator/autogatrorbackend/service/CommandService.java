package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.model.IrrigationRoute;
import com.autogator.autogatrorbackend.model.entity.*;
import com.autogator.autogatrorbackend.model.enums.CommandState;
import com.autogator.autogatrorbackend.model.exception.CommandException;
import com.autogator.autogatrorbackend.model.request.CommandContextRequest;
import com.autogator.autogatrorbackend.model.response.CommandResponse;
import com.autogator.autogatrorbackend.repository.*;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.sql.Timestamp;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommandService {
    private final CommandRepository commandRepository;
    private final MachineRepository machineRepository;
    private final CommandContextRepository commandContextRepository;
    private final GeofenceRepository geofenceRepository;
    private final IrrigationRouteRepository irrigationRouteRepository;
    private final ModelMapper mapper = new ModelMapper();

    public Command queueCommand(CommandContextRequest commandContextRequest) {
        CommandEntity commandEntity = CommandEntity.builder().commandState(CommandState.QUEUED).timeIssued(Timestamp.valueOf(ZonedDateTime.now(ZoneId.of("UTC")).toLocalDateTime())).command(commandContextRequest.getMachineCommand()).machineEntity(getMachineEntity(commandContextRequest.getMachineSerialNumber())).build();
        CommandEntity savedCommand = commandRepository.save(commandEntity);
        saveCommandContext(savedCommand, commandContextRequest.getAdditionalAttributes());
        return mapper.map(savedCommand, Command.class);
    }

    public CommandResponse getNextCommand(String machineSerialNumber) {
        if (commandRepository.findByCommandStateAndMachineEntity(CommandState.IN_PROGRESS, getMachineEntity(machineSerialNumber)).isPresent()) {
            throw new CommandException("Another command is already in progress");
        }
        CommandEntity command = commandRepository.findFirstByCommandStateAndMachineEntityOrderByTimeIssuedAsc(CommandState.QUEUED, getMachineEntity(machineSerialNumber)).orElseThrow(() -> {
            throw new CommandException("There are no queued commands for machine with serial number: " + machineSerialNumber);
        });
        command.setCommandState(CommandState.IN_PROGRESS);
        commandRepository.save(command);
        CommandResponse commandResponse = createCommandResponse(commandContextRepository.findAllByCommandEntity(command));
        commandResponse.setCommand(mapper.map(command, Command.class));
        return commandResponse;
    }

    public Command finishCurrentCommand(String serialNumber) {
        CommandEntity commandEntity = commandRepository.findByCommandStateAndMachineEntity(CommandState.IN_PROGRESS, getMachineEntity(serialNumber)).orElseThrow(() -> {
            throw new CommandException("There are no commands in progress");
        });
        commandEntity.setCommandState(CommandState.FINISHED);
        //commandContextRepository.removeByCommandEntity(commandEntity);
        return mapper.map(commandRepository.save(commandEntity), Command.class);
    }

    private MachineEntity getMachineEntity(String serialNumber) {
        return machineRepository.findBySerialNumber(serialNumber).orElseThrow(() -> {
            throw new CommandException("Machine with serial number: " + serialNumber + "does not exist");
        });
    }

    private void saveCommandContext(CommandEntity commandEntity, Map<String, String> additionalAttributes) {
        for (Map.Entry<String, String> entry : additionalAttributes.entrySet()) {
            commandContextRepository.save(CommandContextEntity.builder().commandEntity(commandEntity).key(entry.getKey()).value(entry.getValue()).build());
        }
    }

    private CommandResponse createCommandResponse(List<CommandContextEntity> commandContextEntities) {
        CommandResponse commandResponse = new CommandResponse();
        commandContextEntities.forEach(commandContextEntity -> {
            switch (commandContextEntity.getKey()) {
            case "geofenceName": 
                commandResponse.setGeofence(mapper.map(getGeofence(commandContextEntity.getValue()), Geofence.class));
            case "irrigationRouteName": 
                commandResponse.setIrrigationRoute(mapper.map(getIrrigationRoute(commandContextEntity.getValue()), IrrigationRoute.class));
            }
        });
        return commandResponse;
    }

    private GeofenceEntity getGeofence(String geofenceName) {
        return geofenceRepository.getGeofenceByGeofenceName(geofenceName).orElseThrow(() -> {
            throw new CommandException("Geofence with name: " + geofenceName);
        });
    }

    private IrrigationRouteEntity getIrrigationRoute(String irrigationRouteName) {
        return irrigationRouteRepository.getIrrigationRouteByRouteName(irrigationRouteName).orElseThrow(() -> {
            throw new CommandException("Route with name: " + irrigationRouteName);
        });
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public CommandService(final CommandRepository commandRepository, final MachineRepository machineRepository, final CommandContextRepository commandContextRepository, final GeofenceRepository geofenceRepository, final IrrigationRouteRepository irrigationRouteRepository) {
        this.commandRepository = commandRepository;
        this.machineRepository = machineRepository;
        this.commandContextRepository = commandContextRepository;
        this.geofenceRepository = geofenceRepository;
        this.irrigationRouteRepository = irrigationRouteRepository;
    }
    //</editor-fold>
}
