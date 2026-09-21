package se331.componentbaseassignment8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se331.componentbaseassignment8.entity.Participant;
import se331.componentbaseassignment8.service.ParticipantService;
import se331.componentbaseassignment8.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class ParticipantController {
    final ParticipantService participantService;

    @GetMapping("/participants")
    public ResponseEntity<?> getParticipants(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page) {
        
        if (perPage == null || page == null) {
            return ResponseEntity.ok(LabMapper.INSTANCE.getParticipantDTO(participantService.getAllParticipants()));
        }

        Page<Participant> pageOutput = participantService.getParticipants(perPage, page - 1);
        
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(pageOutput.getTotalElements()));

        return new ResponseEntity<>(
                LabMapper.INSTANCE.getParticipantDTO(pageOutput.getContent()),
                responseHeader,
                HttpStatus.OK
        );
    }
}