package com.autogator.autogatrorbackend.model.response;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.model.IrrigationRoute;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandResponse {

    private Command command;

    private Geofence geofence;

    private IrrigationRoute irrigationRoute;

    private Map<String, String> additionalAttributes;
}
