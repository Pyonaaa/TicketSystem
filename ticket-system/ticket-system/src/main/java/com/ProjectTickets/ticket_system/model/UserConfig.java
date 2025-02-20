package com.ProjectTickets.ticket_system.model;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
public class UserConfig {
/*
    @Bean
    CommandLineRunner commandLineRunner(UserRepository repository, PasswordEncoder passwordEncoder) {
        return args -> {
            User admin = new User(
                    "Kacper",
                    "admin@example.com",
                    passwordEncoder.encode("password"),
                    "ADMIN",
                    25
            );
            // Dodajemy użytkownika gościa
            User guest = new User(
                    "Guest User",
                    "guest@example.com",
                    passwordEncoder.encode("guestpass"),
                    "USER",
                    25
            );
            repository.saveAll(List.of(admin, guest));
        };
    }*/
}
