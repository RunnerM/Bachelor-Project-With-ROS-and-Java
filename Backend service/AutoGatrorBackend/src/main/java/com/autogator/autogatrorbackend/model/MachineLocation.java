package com.autogator.autogatrorbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineLocation {

    private Long id;

    private String machineSerialNumber;

    private float latitude;

    private float longitude;

}
