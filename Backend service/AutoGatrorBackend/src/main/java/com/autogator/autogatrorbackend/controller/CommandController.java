package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.request.CommandContextRequest;
import com.autogator.autogatrorbackend.model.response.CommandResponse;
import com.autogator.autogatrorbackend.service.CommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/command")
public class CommandController {

    private final CommandService commandService;

    @PostMapping
    public ResponseEntity<Command> queueCommand(@RequestBody CommandContextRequest commandContextRequest) {

        return ResponseEntity.ok(commandService.queueCommand(commandContextRequest));
    }

    @GetMapping
    public ResponseEntity<CommandResponse> getNextCommand(@RequestParam String machineSerialNumber) {

        return ResponseEntity.ok(commandService.getNextCommand(machineSerialNumber));
    }

    @PostMapping("/finishCommand")
    public ResponseEntity<Command> finishCommand(@RequestParam String serialNumber) {

        return ResponseEntity.ok(commandService.finishCurrentCommand(serialNumber));
    }
}
