package org.zoodevelopers.upcoming_events.controllers;

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