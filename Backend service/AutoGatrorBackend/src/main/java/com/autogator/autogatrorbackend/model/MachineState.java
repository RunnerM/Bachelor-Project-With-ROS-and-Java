package com.autogator.autogatrorbackend.model;

import com.autogator.autogatrorbackend.model.enums.MachineStateEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineState {

    private String machineSerialNumber;

    private MachineStateEnum machineStateEnum;
}
