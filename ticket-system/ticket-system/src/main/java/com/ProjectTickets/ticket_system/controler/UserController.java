package com.ProjectTickets.ticket_system.controler;

import com.ProjectTickets.ticket_system.model.User;
import com.ProjectTickets.ticket_system.model.UserRepository;
import com.ProjectTickets.ticket_system.service.UserInfoUserDetailService;
import com.ProjectTickets.ticket_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getUser() {
        return userService.getUser();

    }


    @PostMapping("/save")
    public ResponseEntity<Object> registerNewUser(@RequestBody User user) {
        userService.addNewUser(user);
        return ResponseEntity.ok("User was saved");

    }


    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable("userId") Long userId) {
        userService.deleteUser(userId);

    }

}