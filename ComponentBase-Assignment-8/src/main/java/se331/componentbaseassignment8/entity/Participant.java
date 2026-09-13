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
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    Long id;

    String name;
    String telNo;

    @ManyToMany
    List<Event> eventHistories;
}