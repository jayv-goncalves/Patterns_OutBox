package main.java.com.patterns.outbox_api.ports.in.services;


import main.java.com.patterns.outbox_api.dtos.UserDTO;

public interface UserService {
    UserDTO getUserById(String id);
    UserDTO insertUser(UserDTO userDTO);
    UserDTO updateUser(String id, UserDTO userDTO);
}
