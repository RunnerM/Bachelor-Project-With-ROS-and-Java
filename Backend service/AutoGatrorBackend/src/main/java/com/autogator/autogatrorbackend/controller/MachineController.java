package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.Machine;
import com.autogator.autogatrorbackend.service.MachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machine")
@RequiredArgsConstructor
public class MachineController {

    private final MachineService machineService;

    @PostMapping
    public ResponseEntity<Machine> registerMachine(Machine machine) {

        return ResponseEntity.ok(machineService.registerMachine(machine));
    }
}
