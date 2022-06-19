package com.udemy.micro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {
    @GetMapping(path="/get")
    public String user()
    {
        return String.format("welcome...");
    }
}
