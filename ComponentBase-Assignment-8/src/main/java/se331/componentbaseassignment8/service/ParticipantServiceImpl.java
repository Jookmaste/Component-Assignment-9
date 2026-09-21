package se331.componentbaseassignment8.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    @Override
    public Page<Participant> getParticipants(Integer pageSize, Integer page) {
        return participantDao.getParticipants(PageRequest.of(page, pageSize));
    }
}