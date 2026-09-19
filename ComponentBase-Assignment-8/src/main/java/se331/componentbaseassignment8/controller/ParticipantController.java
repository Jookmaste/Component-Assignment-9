package se331.componentbaseassignment8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.componentbaseassignment8.service.ParticipantService;
import se331.componentbaseassignment8.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;

    @GetMapping("/participants")
    public ResponseEntity<?> getParticipants() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(participantService.getAllParticipants()));
    }
}