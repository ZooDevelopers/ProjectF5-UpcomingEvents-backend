package org.zoodevelopers.upcoming_events;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.zoodevelopers.upcoming_events.models.Events;
import org.zoodevelopers.upcoming_events.repositories.EventsRepository;
import org.zoodevelopers.upcoming_events.services.EventsService;
import org.zoodevelopers.upcoming_events.services.exceptions.EventsNotFoundException;

public class EventsServiceTest {

    @Mock
    private EventsRepository eventsRepository;

    @InjectMocks
    private EventsService eventsService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveEvents() {
        Events event = new Events();
        when(eventsRepository.save(event)).thenReturn(event);

        Events savedEvent = eventsService.saveEvents(event);
        assertEquals(event, savedEvent);
        verify(eventsRepository).save(event);
    }

    @Test
    void testUpdateEvents() {
        Long eventId = 1L;
        Events existingEvent = new Events();
        Events updatedEvent = new Events();
        updatedEvent.setTitle("Updated Title");

        when(eventsRepository.findById(eventId)).thenReturn(Optional.of(existingEvent));
        when(eventsRepository.save(existingEvent)).thenReturn(existingEvent);

        Events result = eventsService.updateEvents(eventId, updatedEvent);
        assertEquals(existingEvent, result);
        assertEquals("Updated Title", existingEvent.getTitle());
        verify(eventsRepository).findById(eventId);
        verify(eventsRepository).save(existingEvent);
    }

    @Test
    void testUpdateEventsNotFound() {
        Long eventId = 1L;
        Events updatedEvent = new Events();

        when(eventsRepository.findById(eventId)).thenReturn(Optional.empty());

        EventsNotFoundException thrown = assertThrows(
            EventsNotFoundException.class,
            () -> eventsService.updateEvents(eventId, updatedEvent)
        );
        assertEquals("Events not found", thrown.getMessage());
        verify(eventsRepository).findById(eventId);
    }

    @Test
    void testDeleteEvents() {
        Long eventId = 1L;
        when(eventsRepository.existsById(eventId)).thenReturn(true);

        eventsService.deleteEvents(eventId);
        verify(eventsRepository).deleteById(eventId);
    }

    @Test
    void testDeleteEventsNotFound() {
        Long eventId = 1L;
        when(eventsRepository.existsById(eventId)).thenReturn(false);

        EventsNotFoundException thrown = assertThrows(
            EventsNotFoundException.class,
            () -> eventsService.deleteEvents(eventId)
        );
        assertEquals("Event not found with id " + eventId, thrown.getMessage());
        verify(eventsRepository, never()).deleteById(eventId);
    }

    @Test
    void testGetAllEvents() {
        Pageable pageable = PageRequest.of(0, 10);
        Events event = new Events();
        Page<Events> page = new PageImpl<>(List.of(event));
        when(eventsRepository.findAll(pageable)).thenReturn(page);

        Page<Events> result = eventsService.getAllEvents(pageable);
        assertEquals(page, result);
        verify(eventsRepository).findAll(pageable);
    }

    @Test
    void testGetFeaturedEvents() {
        Events event = new Events();
        List<Events> featuredEvents = List.of(event);
        when(eventsRepository.findByIsFeaturedTrue()).thenReturn(featuredEvents);

        List<Events> result = eventsService.getFeaturedEvents();
        assertEquals(featuredEvents, result);
        verify(eventsRepository).findByIsFeaturedTrue();
    }
}

