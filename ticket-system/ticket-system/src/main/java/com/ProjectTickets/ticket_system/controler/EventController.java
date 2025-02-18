package com.ProjectTickets.ticket_system.controler;

import com.ProjectTickets.ticket_system.model.Event;
import com.ProjectTickets.ticket_system.model.User;
import com.ProjectTickets.ticket_system.service.EventService;
import com.ProjectTickets.ticket_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvent() {
        return eventService.getEvent();

    }

    @PostMapping
    public void registerNewEvent(@RequestBody Event event) {
        eventService.addNewEvent(event);
    }

    @DeleteMapping(path = "{eventId}")
    public void deleteEvent(@PathVariable("eventId") Long eventId) {
        eventService.deleteEvent(eventId);
    }
}
