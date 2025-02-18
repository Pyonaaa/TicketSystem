package com.ProjectTickets.ticket_system.enums;

public enum TicketStatus {
    ACTIVE,
    CANCELLED,
    USED;
    public static TicketStatus findByTicketStatusOrThrow(String name){
        TicketStatus result = null;
        for(TicketStatus ticketstatus: TicketStatus.values()){
            if(ticketstatus.name().equalsIgnoreCase(name)){
              return ticketstatus;
            }
        }
        throw new IllegalArgumentException("Invalid enum name:" + name);
    }
}
