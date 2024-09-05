package org.zoodevelopers.upcoming_events;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.zoodevelopers.upcoming_events.models.SecurityUser;
import org.zoodevelopers.upcoming_events.models.User; // Ajusta esto según tu implementación
import org.zoodevelopers.upcoming_events.repositories.UserRepository;
import org.zoodevelopers.upcoming_events.services.UserService;

import java.util.Optional;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testLoadUserByUsernameFound() {
        String username = "testUser";
        User user = new User(); // Crea un User o ajusta según tu implementación
        user.setUsername(username);
        SecurityUser securityUser = new SecurityUser(user);
        
        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        UserDetails userDetails = userService.loadUserByUsername(username);
        assertNotNull(userDetails);
        assertTrue(userDetails instanceof SecurityUser);
        assertEquals(securityUser.getUsername(), userDetails.getUsername()); // Ajusta esto según tu implementación
        verify(userRepository).findByUsername(username);
    }

    @Test
    void testLoadUserByUsernameNotFound() {
        String username = "testUser";
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        UsernameNotFoundException thrown = assertThrows(
            UsernameNotFoundException.class,
            () -> userService.loadUserByUsername(username)
        );
        assertEquals("User not found: " + username, thrown.getMessage());
        verify(userRepository).findByUsername(username);
    }
}
