package org.zoodevelopers.upcoming_events.models;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser implements UserDetails {

    User user;

    public SecurityUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
        /* return Collection.singleton(new SimpleGrantedAuthority("ROLE_ADMIN")); */
    }

    @Override
    public String getPassword() {
     return user.getPassword();
    }

    @Override
    public String getUsername() {
     return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
       return true;
    }

    @Override
    public boolean isAccountNonLocked() {
       return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
      return true;
    }
    
}
