package org.zoodevelopers.upcoming_events.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SecurityUserTest {

    private User user;
    private SecurityUser securityUser;

    @BeforeEach
    void setUp() {
        user = mock(User.class);
        securityUser = new SecurityUser(user);
    }

    @Test
    void testGetAuthorities() {
        Role role1 = new Role(1L, "ROLE_USER");
        Role role2 = new Role(2L, "ROLE_ADMIN");

        Set<Role> roles = new HashSet<>(Arrays.asList(role1, role2));
        when(user.getRoles()).thenReturn(roles);

        Collection<? extends GrantedAuthority> authorities = securityUser.getAuthorities();

        assertNotNull(authorities);
        assertEquals(2, authorities.size());
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_USER")));
        assertTrue(authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN")));
    }

    @Test
    void testGetPassword() {
        String password = "password123";
        when(user.getPassword()).thenReturn(password);

        assertEquals(password, securityUser.getPassword());
    }

    @Test
    void testGetUsername() {
        String username = "john_doe";
        when(user.getUsername()).thenReturn(username);

        assertEquals(username, securityUser.getUsername());
    }

    @Test
    void testIsAccountNonExpired() {
        assertTrue(securityUser.isAccountNonExpired());
    }

    @Test
    void testIsAccountNonLocked() {
        assertTrue(securityUser.isAccountNonLocked());
    }

    @Test
    void testIsCredentialsNonExpired() {
        assertTrue(securityUser.isCredentialsNonExpired());
    }

    @Test
    void testIsEnabled() {
        assertTrue(securityUser.isEnabled());
    }
}
