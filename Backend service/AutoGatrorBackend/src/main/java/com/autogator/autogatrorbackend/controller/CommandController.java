package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import com.autogator.autogatrorbackend.service.CommandService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/command")
public class CommandController {

    private final CommandService commandService;

    @PostMapping
    public ResponseEntity<Command> queueCommand(@NotNull @RequestParam MachineCommand command, @RequestParam String machineSerialNumber) {

        return ResponseEntity.ok(commandService.queueCommand(command, machineSerialNumber));
    }

    @GetMapping
    public ResponseEntity<Command> getNextCommand(@RequestParam String serialNumber) {

        return ResponseEntity.ok(commandService.getNextCommand(serialNumber));
    }

    @PostMapping("/finishCommand")
    public ResponseEntity<Command> finishCommand(@RequestParam String serialNumber) {

        return ResponseEntity.ok(commandService.finishCurrentCommand(serialNumber));
    }
}
