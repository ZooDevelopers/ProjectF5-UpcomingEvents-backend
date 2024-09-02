package org.zoodevelopers.upcoming_events.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zoodevelopers.upcoming_events.models.Events;
import org.zoodevelopers.upcoming_events.services.EventsService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(EventsController.class)
class EventsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventsService eventsService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    private Events event1;
    private Events event2;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        event1 = new Events();
        event1.setId(1L);
        event1.setTitle("Event 1");
        event1.setDate(LocalDate.of(2024, 9, 15));
        event1.setMaxparticipants(100);
        event1.setDescription("Description for Event 1");
        event1.setImageUrl("http://example.com/event1.jpg");
        event1.setIs_featured("yes");
        event1.setLocation("Location 1");
        event1.setTime("10:00 AM");

        event2 = new Events();
        event2.setId(2L);
        event2.setTitle("Event 2");
        event2.setDate(LocalDate.of(2024, 10, 20));
        event2.setMaxparticipants(150);
        event2.setDescription("Description for Event 2");
        event2.setImageUrl("http://example.com/event2.jpg");
        event2.setIs_featured("no");
        event2.setLocation("Location 2");
        event2.setTime("2:00 PM");
    }

    @Test
    void testGetAllEvents() throws Exception {
        List<Events> eventsList = Arrays.asList(event1, event2);
        Page<Events> eventsPage = new PageImpl<>(eventsList);

        when(eventsService.getAllEvents(any(Pageable.class))).thenReturn(eventsPage);

        mockMvc.perform(get("/api/v1/events"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].title").value("Event 1"))
                .andExpect(jsonPath("$[1].title").value("Event 2"));

        verify(eventsService, times(1)).getAllEvents(any(Pageable.class));
    }

    @Test
    void testCreateEvents() throws Exception {
        when(eventsService.saveEvents(any(Events.class))).thenReturn(event1);

        mockMvc.perform(post("/api/v1/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Event 1\", \"date\": \"2024-09-15\", \"maxparticipants\": 100, \"description\": \"Description for Event 1\", \"imageUrl\": \"http://example.com/event1.jpg\", \"is_featured\": \"yes\", \"location\": \"Location 1\", \"time\": \"10:00 AM\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Event 1"));

        verify(eventsService, times(1)).saveEvents(any(Events.class));
    }

    @Test
    void testUpdateEvents() throws Exception {
        when(eventsService.updateEvents(eq(1L), any(Events.class))).thenReturn(event1);

        mockMvc.perform(put("/api/v1/events/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Updated Event 1\", \"date\": \"2024-09-15\", \"maxparticipants\": 120, \"description\": \"Updated Description\", \"imageUrl\": \"http://example.com/event1_updated.jpg\", \"is_featured\": \"no\", \"location\": \"Updated Location\", \"time\": \"11:00 AM\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Event 1"));

        verify(eventsService, times(1)).updateEvents(eq(1L), any(Events.class));
    }

    @Test
    void testDeleteEvents() throws Exception {
        doNothing().when(eventsService).deleteEvents(1L);

        mockMvc.perform(delete("/api/v1/events/1"))
                .andExpect(status().isOk());

        verify(eventsService, times(1)).deleteEvents(1L);
    }
}
