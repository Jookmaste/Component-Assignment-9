package se331.componentbaseassignment8.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import se331.componentbaseassignment8.entity.Participant;

import java.util.List;

public interface ParticipantDao {
    List<Participant> getParticipants();
    Page<Participant> getParticipants(Pageable pageRequest);
}