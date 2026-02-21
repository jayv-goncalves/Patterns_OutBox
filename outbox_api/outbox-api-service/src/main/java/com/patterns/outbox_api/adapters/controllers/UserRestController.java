package com.patterns.outbox_api.adapters.controllers;

import com.patterns.outbox_api.dtos.UserDTO;
import com.patterns.outbox_api.ports.in.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    @Transactional
    ResponseEntity<?> insertUser(@RequestBody UserDTO user) {
        UserDTO insertedUser = userService.insertUser(user);
        return ResponseEntity.created(URI.create("/users")).body(insertedUser);
    }

    @PutMapping("/users/{id}")
    @Transactional
    ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody UserDTO user) {
        UserDTO insertedUser = userService.updateUser(id, user);
        return ResponseEntity.ok().body(insertedUser);
    }

    @GetMapping("/users/{id}")
    @Transactional
    ResponseEntity<?> getUser(@PathVariable String id) {
        UserDTO insertedUser = userService.getUserById(id);
        return ResponseEntity.ok().body(insertedUser);
    }
}
