package se331.componentbaseassignment8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.componentbaseassignment8.entity.Organizer;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}