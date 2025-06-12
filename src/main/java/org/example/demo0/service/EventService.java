package org.example.demo0.service;

import org.example.demo0.model.Event;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.time.LocalDateTime;

@Service
public class EventService {
    private final List<Event> events = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public List<Event> getAllEvents() {
        return events;
    }

    public Optional<Event> getEventById(Long id) {
        return events.stream().filter(e -> e.getId().equals(id)).findFirst();
    }

    public Event createEvent(Event event) {
        if (event.getDateTime() == null) {
            event.setDateTime(LocalDateTime.now());
        }
        event.setId(counter.getAndIncrement());
        events.add(event);
        return event;
    }

    public Optional<Event> updateEvent(Long id, Event updatedEvent) {
        return getEventById(id).map(existing -> {
            existing.setTitle(updatedEvent.getTitle());
            existing.setDescription(updatedEvent.getDescription());
            existing.setLocation(updatedEvent.getLocation());
            existing.setDateTime(updatedEvent.getDateTime());
            return existing;
        });
    }

    public boolean deleteEvent(Long id) {
        return events.removeIf(e -> e.getId().equals(id));
    }
}
