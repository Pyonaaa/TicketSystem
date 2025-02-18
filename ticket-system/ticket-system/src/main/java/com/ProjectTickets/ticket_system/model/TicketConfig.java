package com.ProjectTickets.ticket_system.model;

import com.ProjectTickets.ticket_system.enums.TicketStatus;
import com.ProjectTickets.ticket_system.enums.TicketType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TicketConfig {
/*
    @Bean
    CommandLineRunner commandLineRunner3(TicketRepository repository){
        return args -> {
            Ticket standard = new Ticket (
                           250,
                    TicketType.STUDENT,
                     "15",
                    TicketStatus.ACTIVE
                    );
            repository.saveAll(List.of(standard));
        };
    }*/
}
