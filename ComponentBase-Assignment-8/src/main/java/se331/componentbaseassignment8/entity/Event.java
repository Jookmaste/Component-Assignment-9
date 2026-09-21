package se331.componentbaseassignment8.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    Long id;

    String category;
    String title;
    String description;
    String location;
    String date;
    String time;
    Boolean petsAllowed;

    @ManyToOne
    Organizer organizer;

    @ManyToMany(mappedBy = "eventHistory")
    List<Participant> participants;
}