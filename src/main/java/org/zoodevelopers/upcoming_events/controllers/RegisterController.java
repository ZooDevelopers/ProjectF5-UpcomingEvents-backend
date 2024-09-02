package org.zoodevelopers.upcoming_events.controllers;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zoodevelopers.upcoming_events.dtos.UserDto;
import org.zoodevelopers.upcoming_events.services.RegisterService;

@RestController
@RequestMapping(path = "/api/v1/register")

public class RegisterController {
    RegisterService service;
    
    public RegisterController(RegisterService service) {
        this.service = service;
    }
    @PostMapping
    public String register(@RequestHeader String username, @RequestHeader String password, @RequestHeader String email) {
        UserDto newUser = new UserDto();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        return service.save(newUser);
    }
}