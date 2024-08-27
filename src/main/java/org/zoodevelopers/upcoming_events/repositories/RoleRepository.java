package org.zoodevelopers.upcoming_events.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zoodevelopers.upcoming_events.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
