package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.Command;
import com.autogator.autogatrorbackend.model.Geofence;
import com.autogator.autogatrorbackend.service.CommandService;
import com.autogator.autogatrorbackend.service.GeofenceService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommandController {
    @Autowired
    CommandService commandService;

    @PostMapping
    public ResponseEntity<Command> queueCommand(@NotNull @RequestBody Command command) {

        return ResponseEntity.ok(commandService.queueCommand(command));
    }

    @GetMapping
    public ResponseEntity<Command> getNextCommand() {

        return ResponseEntity.ok(commandService.getNextCommand());
    }
}
