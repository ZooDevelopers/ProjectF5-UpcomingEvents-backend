package org.zoodevelopers.upcoming_events.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zoodevelopers.upcoming_events.models.Events;
import org.zoodevelopers.upcoming_events.repositories.EventsRepository;
import org.zoodevelopers.upcoming_events.exceptions.EventsNotFoundException;

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
        events.setIs_featured(updatedEvents.getIs_featured());
        events.setLocation(updatedEvents.getLocation());
        events.setTime(updatedEvents.getTime());

        return eventsRepository.save(events);
    }

    public void deleteEvents(Long id) {
        eventsRepository.deleteById(id);
    }

    public Page<Events> getAllEvents(Pageable pageable) {
        return eventsRepository.findAll(pageable);
    }

    
}
