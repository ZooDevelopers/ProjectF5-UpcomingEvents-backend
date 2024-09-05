package org.zoodevelopers.upcoming_events.dtos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UserDtoTest {

    private UserDto userDto;

    @BeforeEach
    public void setUp() {
        userDto = new UserDto();
    }

    @Test
    public void testSetAndGetUsername() {
        String username = "testUser";
        userDto.setUsername(username);
        assertEquals(username, userDto.getUsername());
    }

    @Test
    public void testSetAndGetPassword() {
        String password = "testPass";
        userDto.setPassword(password);
        assertEquals(password, userDto.getPassword());
    }

    @Test
    public void testSetAndGetEmail() {
        String email = "test@example.com";
        userDto.setEmail(email);
        assertEquals(email, userDto.getEmail());
    }

    @Test
    public void testUserDtoNotNull() {
        assertNotNull(userDto);
    }
}
