package com.autogator.autogatrorbackend.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MachineLocation {

    private Long id;

    private String machineSerialNumber;

    private String location;

    private ZonedDateTime timestamp;

}
