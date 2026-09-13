package se331.componentbaseassignment8.dao;

import org.springframework.data.domain.Page;
import se331.componentbaseassignment8.entity.Event;

public interface EventDao {
    Integer getEventSize();
    Page<Event> getEvents(Integer pageSize, Integer page);
    Event getEvent(Long id);
    Event save(Event event);
}