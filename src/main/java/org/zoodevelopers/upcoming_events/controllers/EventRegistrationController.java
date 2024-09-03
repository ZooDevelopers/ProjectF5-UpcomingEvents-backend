package org.zoodevelopers.upcoming_events.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zoodevelopers.upcoming_events.models.Events;
import org.zoodevelopers.upcoming_events.services.EventRegistrationService;

@RestController
@RequestMapping("/api/v1/event-registrations")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class EventRegistrationController {
    
    @Autowired
    private EventRegistrationService eventRegistrationService;

    @PostMapping("/{eventId}/register")
    public void registerForEvent(@RequestParam Long userId, @PathVariable Long eventId) {   
        eventRegistrationService.registerUserToEvent(userId, eventId);
    }

    @PostMapping("/{eventId}/cancel")
    public void cancelRegistration(@RequestParam Long userId, @PathVariable Long eventId) {
        eventRegistrationService.cancelUserRegistration(userId, eventId);
    }

    @GetMapping("/user/{userId}/registered")
    public Set<Events> getRegisteredEvents(@PathVariable Long userId) {
        return eventRegistrationService.getUserRegisteredEvents(userId);
    }
}