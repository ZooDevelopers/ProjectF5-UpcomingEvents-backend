package org.zoodevelopers.upcoming_events.controllers;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.zoodevelopers.upcoming_events.dtos.UserDto;
import org.zoodevelopers.upcoming_events.services.RegisterService;

public class RegisterControllerTest {

    @Mock
    private RegisterService registerService;

    @InjectMocks
    private RegisterController registerController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegister_Success() {
        // Given
        UserDto newUser = new UserDto();
        newUser.setUsername("testuser");
        newUser.setPassword("password123");
        newUser.setEmail("pepito@gmail.com");

        when(registerService.save(newUser)).thenReturn("Success");

        // When
        String result = registerController.register(newUser);

        // Then
        assertThat(result, is("Success"));
    }

    @Test
    public void testRegister_Failure() {
        // Given
        UserDto newUser = new UserDto();
        newUser.setUsername("testuser");
        newUser.setPassword("password123");
        newUser.setEmail("pepito@gmail.com");

        when(registerService.save(newUser)).thenReturn("Failure");

        // When
        String result = registerController.register(newUser);

        // Then
        assertThat(result, is("Failure"));
    }
}
