package org.zoodevelopers.upcoming_events.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserTest {

    private User user;
    private Profile profile;
    private Set<Role> roles;

    @BeforeEach
    public void setUp() {
        profile = new Profile(1L, "john.doe@example.com", "1234 Zoo St", null);
        roles = new HashSet<>();
        roles.add(new Role(1L, "ROLE_USER"));
        roles.add(new Role(2L, "ROLE_ADMIN"));

        user = new User("john.doe", "password123", profile);
        user.setRoles(roles);
        profile.setUser(user); // Set the user in profile to avoid null in bidirectional relationship
    }

    @Test
    public void testGetters() {
        assertEquals("john.doe", user.getUsername());
        assertEquals("password123", user.getPassword());
        assertEquals(profile, user.getProfile());
        assertEquals(roles, user.getRoles());
    }

    @Test
    public void testSetters() {
        Profile newProfile = new Profile(2L, "jane.doe@example.com", "5678 Safari Dr", null);
        Set<Role> newRoles = new HashSet<>();
        newRoles.add(new Role(3L, "ROLE_MANAGER"));

        user.setUsername("jane.doe");
        user.setPassword("newpassword");
        user.setProfile(newProfile);
        user.setRoles(newRoles);
        newProfile.setUser(user); // Update user in profile

        assertEquals("jane.doe", user.getUsername());
        assertEquals("newpassword", user.getPassword());
        assertEquals(newProfile, user.getProfile());
        assertEquals(newRoles, user.getRoles());
    }

    @Test
    public void testDefaultConstructor() {
        User emptyUser = new User();
        assertNotNull(emptyUser);
    }

   
}
