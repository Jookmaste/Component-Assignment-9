package se331.componentbaseassignment8.dao;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import se331.componentbaseassignment8.entity.Participant;
import se331.componentbaseassignment8.repository.ParticipantRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ParticipantDaoImpl implements ParticipantDao {
    final ParticipantRepository participantRepository;

    @Override
    public List<Participant> getParticipants() {
        return participantRepository.findAll();
    }

    @Override
    public Page<Participant> getParticipants(Pageable pageRequest) {
        return participantRepository.findAll(pageRequest);
    }
}