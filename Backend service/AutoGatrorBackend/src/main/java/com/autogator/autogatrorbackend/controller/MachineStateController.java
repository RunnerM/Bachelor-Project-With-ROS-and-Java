package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.MachineState;
import com.autogator.autogatrorbackend.model.enums.MachineStateEnum;
import com.autogator.autogatrorbackend.service.MachineStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/machineState")
@RequiredArgsConstructor
public class MachineStateController {

    private final MachineStateService machineStateService;

    @PostMapping
    public ResponseEntity<MachineState> updateState(@RequestParam MachineStateEnum machineStateEnum, @RequestParam String machineSerialNumber) {

        return ResponseEntity.ok(machineStateService.updateState(machineStateEnum, machineSerialNumber));
    }

    @GetMapping
    public ResponseEntity<MachineState> updateState(@RequestParam String machineSerialNumber) {

        return ResponseEntity.ok(machineStateService.getMachineStatus(machineSerialNumber));
    }
}
