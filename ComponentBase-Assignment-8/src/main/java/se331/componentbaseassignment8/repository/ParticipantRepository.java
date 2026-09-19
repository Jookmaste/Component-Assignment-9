package se331.componentbaseassignment8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se331.componentbaseassignment8.entity.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}