package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.MachineLocation;
import com.autogator.autogatrorbackend.model.MachineState;
import com.autogator.autogatrorbackend.model.enums.MachineStateEnum;
import com.autogator.autogatrorbackend.service.MachineLocationService;
import com.autogator.autogatrorbackend.service.MachineStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/machineLocation")
public class MachineLocationController {

    private final MachineLocationService machineLocationService;

    @PostMapping
    public ResponseEntity<MachineLocation> updateState(@RequestParam String location, @RequestParam String machineSerialNumber) {

        return ResponseEntity.ok(machineLocationService.updateLocation(location, machineSerialNumber));
    }

    @GetMapping
    public ResponseEntity<MachineLocation> getMachineLocation(@RequestParam String machineSerialNumber) {

        return ResponseEntity.ok(machineLocationService.getCurrentLocation(machineSerialNumber));
    }
}