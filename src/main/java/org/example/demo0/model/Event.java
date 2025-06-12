package org.example.demo0.model;

import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;

public class Event {
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private String location;
    private LocalDateTime dateTime;

    // Constructors
    public Event() {}

    public Event(Long id, String title, String description, String location, LocalDateTime dateTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.location = location;
        this.dateTime = dateTime;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }
}