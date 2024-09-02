package org.zoodevelopers.upcoming_events.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class RoleTest {
    
    @Test
    void testDefaultConstructor(){
        Role role = new Role();
        assertNull(role.getId());
        assertNull(role.getName());
        assertNull(role.getUsers());
    }

    @Test
    void testParameterizedConstructor(){
        Long id = 1L;
        String name = "ADMIN";
        Role role = new Role(id, name);

        assertEquals(id, role.getId());
        assertEquals(name, role.getName());
        assertNull(role.getUsers());
    }

}

