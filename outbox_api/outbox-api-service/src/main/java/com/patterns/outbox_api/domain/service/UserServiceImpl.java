package com.patterns.outbox_api.domain.service;

import com.patterns.outbox_api.domain.entity.UsersEntity;
import com.patterns.outbox_api.domain.entity.UsersEventsEntity;
import com.patterns.outbox_api.dtos.UserDTO;
import com.patterns.outbox_api.ports.in.services.UserService;
import com.patterns.outbox_api.ports.out.repositories.UserRepository;
import com.patterns.outbox_api.ports.out.repositories.UsersEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UsersEventsRepository userEventsRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UsersEventsRepository userEventsRepository) {
        this.userRepository = userRepository;
        this.userEventsRepository = userEventsRepository;
    }

    @Override
    public UserDTO getUserById(String id) {
        UUID uuid = UUID.fromString(id);

        UsersEntity foundUser = userRepository.getReferenceById(uuid);

        UserDTO foundUserDTO = new UserDTO();
        foundUserDTO.setId(foundUser.getId().toString());
        foundUserDTO.setName(foundUser.getName());
        foundUserDTO.setMoney(foundUser.getMoney());

        return foundUserDTO;
    }

    @Override
    public UserDTO insertUser(UserDTO userDTO) {
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setId(UUID.randomUUID());
        usersEntity.setName(userDTO.getName());
        usersEntity.setMoney(userDTO.getMoney());

        UsersEntity insertedUser = userRepository.save(usersEntity);

        UsersEventsEntity usersEventsEntity = new UsersEventsEntity();
        usersEventsEntity.setId_user(usersEventsEntity.getId_user());

        UserDTO insertedUserDTO = new UserDTO();
        insertedUserDTO.setId(insertedUser.getId().toString());
        insertedUserDTO.setName(insertedUser.getName());
        insertedUserDTO.setMoney(insertedUser.getMoney());

        //Convert to Domain/entity
        userEventsRepository.save(usersEventsEntity);

        return insertedUserDTO;
    }

    //TODO: Refact this method
    // Improve this logic of object DIFF
    // Verify if is NULL before updating
    // Improve the way response is returned
    @Override
    public UserDTO updateUser(String id, UserDTO userDTO) {
        UUID uuid = UUID.fromString(id);

        UsersEntity foundUser = userRepository.getReferenceById(uuid);


        foundUser.setName(userDTO.getName());
        foundUser.setMoney(userDTO.getMoney());

        userRepository.save(foundUser);

        userDTO.setId(id);

        return userDTO;
    }
}
