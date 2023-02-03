package com.autogator.autogatrorbackend.controller;

import com.autogator.autogatrorbackend.model.User;
import com.autogator.autogatrorbackend.service.UserService;
import com.sun.istack.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<User> getUser(@RequestParam Long id) {

        return ResponseEntity.ok(userService.getUser(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getUser() {

        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@NotNull @RequestBody User user) {

        return ResponseEntity.ok(userService.createUser(user));
    }

}
