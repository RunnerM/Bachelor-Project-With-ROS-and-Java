package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.MachineState;
import com.autogator.autogatrorbackend.model.enums.MachineStateEnum;
import com.autogator.autogatrorbackend.service.MachineStateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machineState")
public class MachineStateController {
    private final MachineStateService machineStateService;

    @PostMapping
    public ResponseEntity<MachineState> updateState(@RequestParam MachineStateEnum machineStateEnum, @RequestParam String machineSerialNumber) {
        return ResponseEntity.ok(machineStateService.updateState(machineStateEnum, machineSerialNumber));
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public MachineStateController(final MachineStateService machineStateService) {
        this.machineStateService = machineStateService;
    }
    //</editor-fold>
}
