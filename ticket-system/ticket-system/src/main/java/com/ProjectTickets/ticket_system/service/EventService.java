package com.ProjectTickets.ticket_system.service;

import com.ProjectTickets.ticket_system.model.Event;
import com.ProjectTickets.ticket_system.model.EventRepository;
import com.ProjectTickets.ticket_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;}
    public List<Event> getEvent(){
        return eventRepository.findAll();
    }
    public void addNewEvent(Event event){
        if(event.getDateTime().isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("Event cannot take place in past");
        }
    eventRepository.save(event);
    }

    public void deleteEvent(Long eventId) {
        boolean exist = eventRepository.existsById(eventId);
        if(!exist){
            throw new IllegalStateException("Event with this id does not exist");
        }
        eventRepository.deleteById(eventId);
    }
}
