package se331.componentbaseassignment8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.componentbaseassignment8.entity.Event;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAll();
}