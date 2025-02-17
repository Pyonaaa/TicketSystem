package com.ProjectTickets.ticket_system.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

@Configuration
public class EventConfig {
    @Bean
    CommandLineRunner commandLineRunner2(EventRepository repository) {
        return args -> {
            Event concert = new Event(
                    20,
                    "Eurovision",
                    "Krakow",
                    "10.12.2026",
                    "concert"
            );
            repository.saveAll(List.of(concert));
        };

    }
}