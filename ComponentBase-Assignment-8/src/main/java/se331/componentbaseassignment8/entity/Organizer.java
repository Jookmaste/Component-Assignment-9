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
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    Long id;

    String name;

    @OneToMany(mappedBy = "organizer")
    List<Event> ownEvents;
}