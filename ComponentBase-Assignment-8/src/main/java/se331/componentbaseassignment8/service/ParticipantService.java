package se331.componentbaseassignment8.service;

import org.springframework.data.domain.Page;
import se331.componentbaseassignment8.entity.Participant;

import java.util.List;

public interface ParticipantService {
    List<Participant> getAllParticipants();
    Page<Participant> getParticipants(Integer pageSize, Integer page); // ใช้ Integer ทั้งคู่
}