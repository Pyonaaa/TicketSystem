package com.ProjectTickets.ticket_system.model;

import com.ProjectTickets.ticket_system.enums.TicketStatus;
import com.ProjectTickets.ticket_system.enums.TicketType;
import jakarta.persistence.*;

@Entity
@Table
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer price;

    private TicketType ticketType;

    private String seatNumber;

    private TicketStatus ticketStatus;

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Integer getPrice() {
        return price;
    }

    public TicketType getTicketType() {
        return ticketType;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }
}
