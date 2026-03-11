package com.patterns.outbox_api.integration;

import builder.UserDTOBuilder;
import com.patterns.outbox_api.dtos.UserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.mysql.MySQLContainer;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@ActiveProfiles("test.yml")
public class UserIntegrationTest {

    @Container
    static MySQLContainer mysql = new MySQLContainer("mysql:8.0")
            .withDatabaseName("outbox-db")
            .withUsername("appuser")
            .withPassword("apppassword")
            .withInitScript("scripts.sql");

    @DynamicPropertySource
    static void setup(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", mysql::getJdbcUrl);
        registry.add("spring.datasource.username", mysql::getUsername);
        registry.add("spring.datasource.password", mysql::getPassword);
    }

    @Autowired
    TestRestTemplate restTemplate;

    static private String INSERTED_USER_ID = "0ec65aa8-a5e9-4e26-a017-c665b4cb997c";

    @Test
    void insertUser() {
        UserDTO userToCreate = new UserDTOBuilder()
                .name("test")
                .money(100L)
                .build();

        ResponseEntity<UserDTO> response = restTemplate.postForEntity("/users", userToCreate, UserDTO.class);

        assertTrue(response.hasBody());
        assertEquals(201, response.getStatusCode().value());
        assertNotNull(response.getBody().getId());
    }

    @Test
    void getUserById() {
        ResponseEntity<UserDTO> response = restTemplate.getForEntity("/users/" + INSERTED_USER_ID, UserDTO.class);

        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void updateUser() {
        UserDTO userToUpdate = new UserDTOBuilder()
                .name("modified-user")
                .money(200L)
                .build();

        ResponseEntity<UserDTO> response = restTemplate.exchange("/users/" + INSERTED_USER_ID, HttpMethod.PUT, new HttpEntity<>(userToUpdate), UserDTO.class);

        assertTrue(response.hasBody());
        assertEquals(HttpStatusCode.valueOf(200), response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(userToUpdate.getName(), response.getBody().getName());
        assertEquals(userToUpdate.getMoney(), response.getBody().getMoney());
    }
}
