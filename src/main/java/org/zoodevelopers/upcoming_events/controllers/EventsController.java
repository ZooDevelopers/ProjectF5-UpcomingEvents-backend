package org.zoodevelopers.upcoming_events.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zoodevelopers.upcoming_events.models.Events;
import org.zoodevelopers.upcoming_events.services.EventsService;

@RestController
@RequestMapping("/api/v1/events")
@CrossOrigin(origins = "http://localhost:5173", allowedHeaders = "*")
public class EventsController {
    
    @Autowired
    private EventsService eventsService;

    @GetMapping
    public List<Events> getAllEvents() {
        return eventsService.getAllEvents(Pageable.unpaged()).getContent();
    }

    @PostMapping("/{id}")
    public Events createEvents(@RequestBody Events events) {
        return eventsService.saveEvents(events);
    }

   @PutMapping("/{id}")
    public Events updaEvents(@PathVariable Long id, @RequestBody Events events){
        return eventsService.updateEvents(id, events);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvents(@PathVariable Long id) {
    eventsService.deleteEvents(id);
    return ResponseEntity.noContent().build();
}

   

}
