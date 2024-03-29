package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.MachineLocation;
import com.autogator.autogatrorbackend.model.MachineState;
import com.autogator.autogatrorbackend.model.enums.MachineStateEnum;
import com.autogator.autogatrorbackend.service.MachineLocationService;
import com.autogator.autogatrorbackend.service.MachineStateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machineLocation")
public class MachineLocationController {
    private final MachineLocationService machineLocationService;

    @PostMapping
    public ResponseEntity<MachineLocation> updateState(@RequestParam String location, @RequestParam String machineSerialNumber) {
        return ResponseEntity.ok(machineLocationService.updateLocation(location, machineSerialNumber));
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public MachineLocationController(final MachineLocationService machineLocationService) {
        this.machineLocationService = machineLocationService;
    }
    //</editor-fold>
}
