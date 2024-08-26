package org.zoodevelopers.upcoming_events.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zoodevelopers.upcoming_events.models.User;

public interface UserRepository extends JpaRepository<User, Long>  {
    public Optional<User> findByUsername(String username);
}
