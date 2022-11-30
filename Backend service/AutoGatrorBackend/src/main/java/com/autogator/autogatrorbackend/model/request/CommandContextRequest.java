package com.autogator.autogatrorbackend.model.request;

import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandContextRequest {

    private MachineCommand machineCommand;

    private String machineSerialNumber;

    private Map<String, String> additionalAttributes;
}
