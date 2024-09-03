package org.zoodevelopers.upcoming_events.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zoodevelopers.upcoming_events.models.Events;
import org.zoodevelopers.upcoming_events.models.User;
import org.zoodevelopers.upcoming_events.repositories.EventsRepository;
import org.zoodevelopers.upcoming_events.repositories.UserRepository;

@Service
public class EventRegistrationService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventsRepository eventsRepository;

    public void registerUserToEvent(Long userId, Long eventId) {

        User user = userRepository.findById(userId).orElseThrow();
        Events event = eventsRepository.findById(eventId).orElseThrow();
        user.getRegisteredEvents().add(event);
        userRepository.save(user);
    }

    public void cancelUserRegistration(Long userId, Long eventId) {
    
        User user = userRepository.findById(userId).orElseThrow();
        Events event = eventsRepository.findById(eventId).orElseThrow();
        user.getRegisteredEvents().remove(event);
        userRepository.save(user);
    }

    public Set<Events> getUserRegisteredEvents(Long userId) {
        
        User user = userRepository.findById(userId).orElseThrow();
        return user.getRegisteredEvents();
    }
}
