package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.Machine;
import com.autogator.autogatrorbackend.service.MachineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/machine")
public class MachineController {
    private final MachineService machineService;

    @PostMapping
    public ResponseEntity<Machine> registerMachine(@RequestBody Machine machine) {
        return ResponseEntity.ok(machineService.registerMachine(machine));
    }

    //<editor-fold defaultstate="collapsed" desc="delombok">
    @SuppressWarnings("all")
    public MachineController(final MachineService machineService) {
        this.machineService = machineService;
    }
    //</editor-fold>
}
