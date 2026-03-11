package com.patterns.outbox_api.domain.entity;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "users_events")
public class UsersEventsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_event;

    @Column(columnDefinition = "BINARY(16)")
    private UUID id_user;

    private String status;

    public UsersEventsEntity() {}

    public UsersEventsEntity(UUID id_user, String status) {
        this.id_user = id_user;
        this.status = status;
    }

    public Long getId_event() {
        return id_event;
    }

    public void setId_event(Long id_event) {
        this.id_event = id_event;
    }

    public UUID getId_user() {
        return id_user;
    }

    public void setId_user(UUID id_user) {
        this.id_user = id_user;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}