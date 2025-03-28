package com.ProjectTickets.ticket_system.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int capacity;
    private String eventName;
    private String location;
    private LocalDateTime dateTime;

    private String category;
    public Event() {
    }

    public Event(int capacity, String eventName, String location, LocalDateTime dateTime, String category) {
        this.capacity = capacity;
        this.eventName = eventName;
        this.location = location;
        this.dateTime = dateTime;
        this.category = category;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }


    public Long getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", capacity=" + capacity +
                ", eventName='" + eventName + '\'' +
                ", location='" + location + '\'' +
                ", dateTime=" + dateTime +
                ", category='" + category + '\'' +
                '}';
    }
}
