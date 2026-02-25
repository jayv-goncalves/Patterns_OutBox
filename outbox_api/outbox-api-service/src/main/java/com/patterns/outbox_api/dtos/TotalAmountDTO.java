package main.java.com.patterns.outbox_api.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalAmountDTO {
    @JsonProperty("total_money_transferred")
    Long money;

    public TotalAmountDTO(Long money) {
        this.money = money;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
