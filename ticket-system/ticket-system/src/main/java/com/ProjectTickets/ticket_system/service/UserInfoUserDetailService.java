package com.ProjectTickets.ticket_system.service;
import com.ProjectTickets.ticket_system.config.UserInfoDetails;
import com.ProjectTickets.ticket_system.model.User;
import com.ProjectTickets.ticket_system.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

@Configuration
public class UserInfoUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(username);
    return user.map(UserInfoDetails::new).orElseThrow(()->new UsernameNotFoundException("User does not exist"));
    }
}
