package org.example.demo0.controller;

import org.example.demo0.model.Event;
import org.example.demo0.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventService service;

    public EventController(EventService service) {
        this.service = service;
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return service.getAllEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Event> getEvent(@PathVariable Long id) {
        return service.getEventById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(service.createEvent(event));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event event) {
        return service.updateEvent(id, event)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        if (service.deleteEvent(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
