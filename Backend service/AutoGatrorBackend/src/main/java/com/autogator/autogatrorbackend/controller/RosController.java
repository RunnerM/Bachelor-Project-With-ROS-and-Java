package com.autogator.autogatrorbackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ros")
public class RosController {

    @GetMapping
    public String test() {

        return "success";
    }

}

