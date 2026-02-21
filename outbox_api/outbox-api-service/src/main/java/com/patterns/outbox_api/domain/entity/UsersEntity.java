package com.patterns.outbox_api.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "users")
public class UsersEntity {
    @Id
    private UUID id;

    private String name;

    private Long money;

    public UsersEntity() {}

    public UsersEntity(UUID id, String name, Long money) {
        this.id = id;
        this.name = name;
        this.money = money;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
