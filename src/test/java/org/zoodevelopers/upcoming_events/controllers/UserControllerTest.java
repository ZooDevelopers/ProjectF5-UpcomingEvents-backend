package org.zoodevelopers.upcoming_events.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    // Test para verificar el login con un usuario autenticado usando @WithMockUser
    @Test
    @WithMockUser(username = "testUser", roles = {"USER"})
    public void testLogin() throws Exception {
        mockMvc.perform(get("/api/v1/login")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isAccepted())
                .andExpect(jsonPath("$.Message").value("Logged"))
                .andExpect(jsonPath("$.Username").value("testUser"))
                .andExpect(jsonPath("$.role").value("ROLE_USER"));
    }
}
