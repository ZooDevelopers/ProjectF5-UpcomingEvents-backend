package org.zoodevelopers.upcoming_events.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zoodevelopers.upcoming_events.models.Events;

@Repository
public interface EventsRepository extends JpaRepository<Events, Long>{
    Page<Events> findAll(Pageable pageable);
    List<Events> findByIsFeaturedTrue();
    
}