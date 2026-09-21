package se331.componentbaseassignment8.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se331.componentbaseassignment8.entity.Organizer;
import se331.componentbaseassignment8.service.OrganizerService;
import se331.componentbaseassignment8.util.LabMapper;

@RestController
@RequiredArgsConstructor
public class OrganizerController {
    final OrganizerService organizerService;

    @GetMapping("/organizers")
    public ResponseEntity<?> getOrganizers() {
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(organizerService.getAllOrganizer()));
    }

    @PostMapping("/organizers")
    public ResponseEntity<?> saveOrganizer(@RequestBody Organizer organizer) {
        Organizer savedOrganizer = organizerService.save(organizer);
        return ResponseEntity.ok(LabMapper.INSTANCE.getOrganizerDTO(savedOrganizer));
    }
}