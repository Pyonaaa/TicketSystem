package com.ProjectTickets.ticket_system.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface EventRepository extends JpaRepository<Event,Long> {
    Optional<Event> findByEventName(String eventName);
    Optional<Event> findById(Long eventId);
}
