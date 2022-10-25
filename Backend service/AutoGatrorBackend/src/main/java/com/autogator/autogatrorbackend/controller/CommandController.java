package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.enums.MachineCommand;
import com.autogator.autogatrorbackend.service.CommandService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/command")
public class CommandController {
    @Autowired
    CommandService commandService;

    @PostMapping
    public ResponseEntity<Command> queueCommand(@NotNull @RequestParam MachineCommand command) {

        return ResponseEntity.ok(commandService.queueCommand(command));
    }

    @GetMapping
    public ResponseEntity<Command> getNextCommand() throws Exception {

        return ResponseEntity.ok(commandService.getNextCommand());
    }

    @PostMapping("/finishCommand")
    public ResponseEntity<Command> finishCommand() throws Exception {

        return ResponseEntity.ok(commandService.finishCurrentCommand());
    }
}
