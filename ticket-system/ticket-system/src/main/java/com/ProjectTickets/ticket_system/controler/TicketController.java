package com.ProjectTickets.ticket_system.controler;

import com.ProjectTickets.ticket_system.enums.TicketType;
import com.ProjectTickets.ticket_system.model.Event;
import com.ProjectTickets.ticket_system.model.EventRepository;
import com.ProjectTickets.ticket_system.model.Ticket;
import com.ProjectTickets.ticket_system.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    private final TicketService ticketService;
    private final EventRepository eventRepository;
    public TicketController(TicketService ticketService, EventRepository eventRepository) {
        this.ticketService = ticketService;
        this.eventRepository = eventRepository;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Ticket> getTicket() {
        return ticketService.getTicket();

    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> addTicketsToEvent(
            @RequestParam Long eventId,
            @RequestParam int capacity,
            @RequestParam TicketType ticketType,
            @RequestParam Integer price) {

        if (capacity <= 0) {
            return ResponseEntity.badRequest().body("Capacity must be greater than 0");
        }

        if (price == null || price < 0) {
            return ResponseEntity.badRequest().body("Price must be a positive number");
        }

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new IllegalArgumentException("Event not found"));

        ticketService.addTicketToEvent(event, capacity, price, ticketType);
        return ResponseEntity.ok("Tickets successfully added to the event.");
    }


    @DeleteMapping(path = "{ticketId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEvent(@PathVariable("ticketId") Long ticketId) {
        ticketService.deleteTicket(ticketId);
    }
    @PostMapping("/buy")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> buyTicket(
            @RequestParam String eventName,
            @RequestParam Long ticketId,
            @RequestParam Long userId) {
        try {
            ticketService.buyTicketByUser(eventName, ticketId, userId);
            return ResponseEntity.ok("Ticket successfully bought.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error buying ticket: " + e.getMessage());
        }
    }
}
