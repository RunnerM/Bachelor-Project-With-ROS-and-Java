package com.autogator.autogatrorbackend.service;

import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.model.IrrigationRoute;
import com.autogator.autogatrorbackend.model.entity.CommandContextEntity;
import com.autogator.autogatrorbackend.model.entity.CommandEntity;
import com.autogator.autogatrorbackend.model.response.CommandResponse;
import com.autogator.autogatrorbackend.repository.CommandContextRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandContextService {

    private final CommandContextRepository commandContextRepository;
    private final GeofenceService geofenceService;
    private final IrrigationRouteService irrigationRouteService;
    private final ModelMapper mapper;

    public void saveCommandContext(CommandEntity CommandEntity, Map<String, String> additionalAttributes) {

        for (Map.Entry<String, String> entry : additionalAttributes.entrySet()) {
            commandContextRepository.save(CommandContextEntity.builder().
                    CommandEntity(CommandEntity).
                    key(entry.getKey()).
                    value(entry.getValue()).
                    build());
        }

    }

    public CommandResponse createCommandResponse(List<CommandContextEntity> commandContextEntities) {

        CommandResponse commandResponse = new CommandResponse();
        Map<String, String> additionalAttributes = new HashMap<>();

        commandContextEntities.forEach(commandcontext -> {
            switch (commandcontext.getKey()) {
                case "geofenceName":
                    commandResponse.setGeofence(mapper.map(geofenceService
                            .getGeofence(commandcontext.getValue()), Geofence.class));
                case "irrigationRouteName":
                    commandResponse.setIrrigationRoute(mapper.map(irrigationRouteService
                            .getRoute(commandcontext.getValue()), IrrigationRoute.class));
                default:
                    additionalAttributes.put(commandcontext.getKey(), commandcontext.getValue());
            }
        });

        commandResponse.setAdditionalAttributes(additionalAttributes);

        return commandResponse;
    }

}