package org.zoodevelopers.upcoming_events.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zoodevelopers.upcoming_events.models.Events;
import org.zoodevelopers.upcoming_events.repository.EventsRepository;

@Service
public class EventsService {
   @Autowired
   private EventsRepository eventsRepository; 

   public Page<Events>getAllEvents(Pageable pageable) {
        return eventsRepository.findAll(pageable);
    }

public Events saveEvents(Events events){
    return eventsRepository.save(events);
}

}
