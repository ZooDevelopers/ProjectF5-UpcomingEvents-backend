package org.zoodevelopers.upcoming_events.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zoodevelopers.upcoming_events.dtos.UserDto;

@RestController
@RequestMapping(path = "${api-endpoint}/register")
public class RegisterController {

    RegisterService service;

    public RegisterController(RegisterService service) {
        this.service = service;
    }

    @PostMapping
    public String register(@RequestBody UserDto newUser) {
        return service.save(newUser);
    }

}