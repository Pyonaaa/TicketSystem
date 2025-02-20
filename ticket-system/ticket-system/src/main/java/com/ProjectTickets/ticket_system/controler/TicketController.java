package com.ProjectTickets.ticket_system.controler;

import com.ProjectTickets.ticket_system.enums.TicketStatus;
import com.ProjectTickets.ticket_system.enums.TicketType;
import com.ProjectTickets.ticket_system.model.Event;
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

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public List<Ticket> getTicket() {
        return ticketService.getTicket();

    }

    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public void registerNewTicket(@RequestBody Ticket ticket) {
        ticketService.addNewTicket(ticket);

    }

    @DeleteMapping(path = "{ticketId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteEvent(@PathVariable("ticketId") Long ticketId) {
        ticketService.deleteTicket(ticketId);
    }
}