package com.ProjectTickets.ticket_system.model;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
