package com.ProjectTickets.ticket_system.enums;

public enum TicketType {
    STANDARD,
    STUDENT,
    REDUCED,
    SENIOR;
    public static TicketType findByTicketTypeOrThrow(String name){
        TicketType result = null;
        for(TicketType ticketType: TicketType.values()){
            if(ticketType.name().equalsIgnoreCase(name)){
                return ticketType;
            }
        }
        throw new IllegalArgumentException("Invalid enum name:" + name);
    }
}
