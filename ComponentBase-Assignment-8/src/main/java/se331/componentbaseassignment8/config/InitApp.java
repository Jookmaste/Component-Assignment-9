package se331.componentbaseassignment8.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.componentbaseassignment8.entity.Event;
import se331.componentbaseassignment8.entity.Organizer;
import se331.componentbaseassignment8.entity.Participant;
import se331.componentbaseassignment8.repository.EventRepository;
import se331.componentbaseassignment8.repository.OrganizerRepository;
import se331.componentbaseassignment8.repository.ParticipantRepository;

import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    final EventRepository eventRepository;
    final OrganizerRepository organizerRepository;
    final ParticipantRepository participantRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        // 1. สร้างและบันทึก Organizers
        Organizer org1 = organizerRepository.save(Organizer.builder().name("CAMT").build());
        Organizer org2 = organizerRepository.save(Organizer.builder().name("CMU").build());
        Organizer org3 = organizerRepository.save(Organizer.builder().name("Chiang Mai").build());
        Organizer org4 = organizerRepository.save(Organizer.builder().name("Chiang Mai Municipality").build());

        // 2. สร้างและบันทึก Events โดยผูกกับ Organizer
        Event e1 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petsAllowed(false)
                .organizer(org1)
                .participants(new ArrayList<>())
                .build());

        Event e2 = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Commencement Day")
                .description("A time for celebration")
                .location("CMU Convention hall")
                .date("21th Jan")
                .time("8.00am-4.00 pm.")
                .petsAllowed(false)
                .organizer(org2)
                .participants(new ArrayList<>())
                .build());

        Event e3 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petsAllowed(false)
                .organizer(org3)
                .participants(new ArrayList<>())
                .build());

        Event e4 = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petsAllowed(true)
                .organizer(org4)
                .participants(new ArrayList<>())
                .build());

        Participant p1 = Participant.builder().name("Participant 1").telNo("081-1111111").eventHistory(new ArrayList<>()).build();
        Participant p2 = Participant.builder().name("Participant 2").telNo("082-2222222").eventHistory(new ArrayList<>()).build();
        Participant p3 = Participant.builder().name("Participant 3").telNo("083-3333333").eventHistory(new ArrayList<>()).build();
        Participant p4 = Participant.builder().name("Participant 4").telNo("084-4444444").eventHistory(new ArrayList<>()).build();
        Participant p5 = Participant.builder().name("Participant 5").telNo("085-5555555").eventHistory(new ArrayList<>()).build();

        p1.getEventHistory().add(e1); p1.getEventHistory().add(e2); p1.getEventHistory().add(e3); p1.getEventHistory().add(e4);
        p2.getEventHistory().add(e1); p2.getEventHistory().add(e2); p2.getEventHistory().add(e3); p2.getEventHistory().add(e4);
        p3.getEventHistory().add(e1); p3.getEventHistory().add(e2); p3.getEventHistory().add(e3); p3.getEventHistory().add(e4);

        p4.getEventHistory().add(e1);
        p5.getEventHistory().add(e2);

        participantRepository.save(p1);
        participantRepository.save(p2);
        participantRepository.save(p3);
        participantRepository.save(p4);
        participantRepository.save(p5);
    }
}