package com.ProjectTickets.ticket_system.service;

import com.ProjectTickets.ticket_system.enums.TicketStatus;
import com.ProjectTickets.ticket_system.enums.TicketType;
import com.ProjectTickets.ticket_system.model.Event;
import com.ProjectTickets.ticket_system.model.Ticket;
import com.ProjectTickets.ticket_system.model.TicketRepository;
import com.ProjectTickets.ticket_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;

@Autowired
    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;}

    public List<Ticket> getTicket(){
    return ticketRepository.findAll();
    }
    public void addNewTicket(Ticket ticket){
    TicketStatus ticketStatus = TicketStatus.findByTicketStatusOrThrow(ticket.getTicketStatus().name());
        TicketType ticketType = TicketType.findByTicketTypeOrThrow(ticket.getTicketType().name());
    ticketRepository.save(ticket);
}
    public void deleteTicket(Long ticketId) {
        boolean exist = ticketRepository.existsById(ticketId);
        if(!exist){
            throw new IllegalStateException("Ticket with this id does not exist");
        }
        ticketRepository.deleteById(ticketId);
    }
}
