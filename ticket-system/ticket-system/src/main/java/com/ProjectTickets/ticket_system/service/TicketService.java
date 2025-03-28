package com.ProjectTickets.ticket_system.service;

import com.ProjectTickets.ticket_system.enums.TicketStatus;
import com.ProjectTickets.ticket_system.enums.TicketType;
import com.ProjectTickets.ticket_system.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;

    @Autowired
    public TicketService(TicketRepository ticketRepository, EventRepository eventRepository, UserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
    }

    public List<Ticket> getTicket() {
        return ticketRepository.findAll();
    }

    public void addNewTicket(Ticket ticket) {
        TicketStatus ticketStatus = TicketStatus.findByTicketStatusOrThrow(ticket.getTicketStatus().name());
        TicketType ticketType = TicketType.findByTicketTypeOrThrow(ticket.getTicketType().name());
        ticketRepository.save(ticket);
    }

    public void addTicketToEvent(Event event, int capacity, Integer price, TicketType ticketType) {
        for (int i = 0; i < capacity; i++) {
            Ticket ticket = new Ticket();
            ticket.setEvent(event);
            ticket.setPrice(price);
            ticket.setTicketType(ticketType);
            ticket.setTicketStatus(TicketStatus.ACTIVE);
            ticketRepository.save(ticket);
        }
    }

    public void deleteTicket(Long ticketId) {
        boolean exist = ticketRepository.existsById(ticketId);
        if (!exist) {
            throw new IllegalStateException("Ticket with this id does not exist");
        }
        ticketRepository.deleteById(ticketId);
    }

    public void buyTicketByUser(String eventName, Long ticketId, Long userId) {
        Event event = eventRepository.findByEventName(eventName)
                .orElseThrow(() -> new RuntimeException("Event not found"));

        Ticket ticket = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new RuntimeException("Ticket not found"));

        if (!ticket.getEvent().equals(event)) {
            throw new IllegalArgumentException("This ticket does not belong to the given event");
        }

        if (ticket.getTicketStatus() != TicketStatus.ACTIVE) {
            throw new IllegalStateException("Ticket is not available");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        ticket.setUser(user);
        ticket.setTicketStatus(TicketStatus.USED);
        ticketRepository.save(ticket);
    }

}

