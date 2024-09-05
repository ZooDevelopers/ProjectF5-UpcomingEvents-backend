package org.zoodevelopers.upcoming_events.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zoodevelopers.upcoming_events.models.Events;
import org.zoodevelopers.upcoming_events.repositories.EventsRepository;
<<<<<<< HEAD
import org.zoodevelopers.upcoming_events.exceptions.EventsNotFoundException;
=======
import org.zoodevelopers.upcoming_events.services.exceptions.EventsNotFoundException;
>>>>>>> bb89f832908554bca757ae02793b6acb9802910f

@Service
public class EventsService {
    @Autowired
    private EventsRepository eventsRepository;

    public Events saveEvents(Events events) {
        return eventsRepository.save(events);
    }

    public Events updateEvents(Long id, Events updatedEvents) {
        Events events = eventsRepository.findById(id)
        .orElseThrow(() -> new EventsNotFoundException("Events not found"));

        events.setTitle(updatedEvents.getTitle());
        events.setDate(updatedEvents.getDate());
        events.setMaxparticipants(updatedEvents.getMaxparticipants());
        events.setDescription(updatedEvents.getDescription());
        events.setImageUrl(updatedEvents.getImageUrl());
        events.setIsFeatured(updatedEvents.getIsFeatured());
        events.setLocation(updatedEvents.getLocation());
        events.setTime(updatedEvents.getTime());

        return eventsRepository.save(events);
    }

    public void deleteEvents(Long id) {
        if (!eventsRepository.existsById(id)) {
            throw new EventsNotFoundException("Event not found with id " + id);
        }
        try {
            eventsRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete event", e);
        }
    }
    

    public Page<Events> getAllEvents(Pageable pageable) {
        return eventsRepository.findAll(pageable);
    }

    public List<Events> getFeaturedEvents() {
        return eventsRepository.findByIsFeaturedTrue();
    }

    
}
