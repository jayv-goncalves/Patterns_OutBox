package com.patterns.outbox_api.domain.service;

import builder.UserDTOBuilder;
import com.patterns.outbox_api.domain.entity.UsersEntity;
import com.patterns.outbox_api.dtos.UserDTO;
import com.patterns.outbox_api.ports.out.repositories.UserRepository;
import com.patterns.outbox_api.ports.out.repositories.UsersEventsRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    UserRepository userRepository;
    @Mock
    UsersEventsRepository userEventsRepository;
    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Test
    void getUserById() {
        UUID userId = UUID.randomUUID();
        UserDTO expectedUser = new UserDTOBuilder()
                .id(userId.toString())
                .name("mock-name")
                .money(100L)
                .build();

        when(userRepository.getReferenceById(userId)).thenReturn(new UsersEntity(userId, expectedUser.getName(), expectedUser.getMoney()));

        UserDTO result = userServiceImpl.getUserById(userId.toString());

        assertEquals(expectedUser.getName(), result.getName());
        assertEquals(expectedUser.getMoney(), result.getMoney());
        assertEquals(userId.toString(), result.getId());
    }

    @Test
    void insertUser() {
    }

    @Test
    void updateUser() {
    }
}