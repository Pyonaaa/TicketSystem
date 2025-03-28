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
    @Enumerated(EnumType.STRING)
    private TicketType ticketType;

    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id")
    private Event event;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Ticket() {

    }

    public Ticket(Integer price, TicketType ticketType, String seatNumber, TicketStatus ticketStatus) {
        this.price = price;
        this.ticketType = ticketType;
        this.seatNumber = seatNumber;
        this.ticketStatus = ticketStatus;
    }

    public Event getEvent() {
        return event;
    }

    public User getUser() {
        return user;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", ticketType=" + ticketType +
                ", seatNumber='" + seatNumber + '\'' +
                ", ticketStatus=" + ticketStatus +
                '}';
    }
}
