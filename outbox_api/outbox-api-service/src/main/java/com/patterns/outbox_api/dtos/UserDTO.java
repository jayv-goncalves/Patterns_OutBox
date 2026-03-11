package com.patterns.outbox_api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class UserDTO {
    public String id;
    @NotBlank
    public String name;
    @Positive
    public Long money;

    public UserDTO() {}

    public UserDTO(String id, String name, Long money) {
        this.id = id;
        this.name = name;
        this.money = money;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
