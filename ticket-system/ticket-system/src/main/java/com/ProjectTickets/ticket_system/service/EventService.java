package com.ProjectTickets.ticket_system.service;

import com.ProjectTickets.ticket_system.model.Event;
import com.ProjectTickets.ticket_system.model.EventRepository;
import com.ProjectTickets.ticket_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EventService {

    private final EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;}
    public List<Event> getEvent(){
        return eventRepository.findAll();
    }
}
