package se331.componentbaseassignment8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import se331.componentbaseassignment8.dao.ParticipantDao;
import se331.componentbaseassignment8.entity.Participant;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {
    final ParticipantDao participantDao;

    @Override
    public List<Participant> getAllParticipants() {
        return participantDao.getParticipants();
    }
}