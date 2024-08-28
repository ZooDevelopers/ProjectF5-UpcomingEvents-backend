package org.zoodevelopers.upcoming_events.controllers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.zoodevelopers.upcoming_events.models.Events;
import org.zoodevelopers.upcoming_events.services.EventsService;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class EventsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EventsService eventsService;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllEvents() throws Exception {
        Events event = new Events();
        event.setTitle("Event Title");
        event.setDate(LocalDate.now());
        event.setMaxparticipants(100);
        event.setDescription("Event Description");
        event.setImageUrl("http://example.com/image.png");
        event.setIs_featured("yes");
        event.setLocation("Event Location");
        event.setTime("12:00");

        Page<Events> page = new PageImpl<>(Collections.singletonList(event));

        when(eventsService.getAllEvents(Pageable.unpaged())).thenReturn(page);

        mockMvc.perform(get("/api/v1/events"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Event Title"))
                .andExpect(jsonPath("$[0].maxParticipants").value(100))
                .andExpect(jsonPath("$[0].location").value("Event Location"));
    }

    @Test
    public void testCreateEvents() throws Exception {
        Events event = new Events();
        event.setTitle("Event Title");
        event.setDate(LocalDate.now());
        event.setMaxparticipants(100);
        event.setDescription("Event Description");
        event.setImageUrl("http://example.com/image.png");
        event.setIs_featured("yes");
        event.setLocation("Event Location");
        event.setTime("12:00");

        when(eventsService.saveEvents(any(Events.class))).thenReturn(event);

        mockMvc.perform(post("/api/v1/events")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(event)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Event Title"))
                .andExpect(jsonPath("$.maxParticipants").value(100))
                .andExpect(jsonPath("$.location").value("Event Location"));
    }
}

