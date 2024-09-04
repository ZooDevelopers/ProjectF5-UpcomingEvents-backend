package org.zoodevelopers.upcoming_events.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

public class EventsTest {
    
    private Events event;

    @BeforeEach
    public void setUp(){
        event = new Events(
                1L,
                "Zoo Festival",
                LocalDate.of(2024, 9, 20),
                100,
                "A fun day at the zoo with various activities.",
                "http://example.com/image.jpg",
                true,
                "Central Zoo",
                "10:00 AM"
        );

}

    @Test
    public void testGetters(){
        assertEquals(1L, event.getId());
        assertEquals("Zoo Festival", event.getTitle());
        assertEquals(LocalDate.of(2024, 9, 20), event.getDate());
        assertEquals(100, event.getMaxparticipants());
        assertEquals("A fun day at the zoo with various activities.", event.getDescription()); 
        assertEquals("http://example.com/image.jpg", event.getImageUrl());
        assertEquals(true, event.getIs_featured());
        assertEquals("Central Zoo", event.getLocation());
        assertEquals("10:00 AM", event.getTime());

    }

    @Test
    public void testSetters() {
        event.setId(2L);
        event.setTitle("Wildlife Adventure");
        event.setDate(LocalDate.of(2024, 10, 15));
        event.setMaxparticipants(200);
        event.setDescription("Explore the wildlife with experts.");
        event.setImageUrl("http://example.com/newimage.jpg");
        event.setIs_featured(false);
        event.setLocation("Safari Park");
        event.setTime("09:00 AM");

        assertEquals(2L, event.getId());
        assertEquals("Wildlife Adventure", event.getTitle());
        assertEquals(LocalDate.of(2024, 10, 15), event.getDate());
        assertEquals(200, event.getMaxparticipants());
        assertEquals("Explore the wildlife with experts.", event.getDescription());
        assertEquals("http://example.com/newimage.jpg", event.getImageUrl());
        assertEquals(false, event.getIs_featured());
        assertEquals("Safari Park", event.getLocation());
        assertEquals("09:00 AM", event.getTime());
    }

    @Test
    public void testDefaultConstructor() {
        Events emptyEvent = new Events();
        assertNotNull(emptyEvent);
    }
}

