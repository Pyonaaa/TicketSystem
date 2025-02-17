package com.ProjectTickets.ticket_system.service;

import com.ProjectTickets.ticket_system.model.User;
import com.ProjectTickets.ticket_system.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUser(){
       return userRepository.findAll();
    }

    public void addNewUser(User user) {
        Optional<User> userByEmail= userRepository.findUserByEmail(user.getEmail());
        if(userByEmail.isPresent()){
            throw new IllegalStateException("email has already been used");
        }
        userRepository.save(user);
    }

    public void deleteUser(Long userId) {
        boolean exist = userRepository.existsById(userId);
    if(!exist){
        throw new IllegalStateException("user with this id does not exist");
    }
userRepository.deleteById(userId);
    }
}
