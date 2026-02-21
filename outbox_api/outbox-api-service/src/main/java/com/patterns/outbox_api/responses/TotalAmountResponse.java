package com.patterns.outbox_api.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TotalAmountResponse{
    @JsonProperty("total_money_transferred")
    Long money;

    public TotalAmountResponse(Long money) {
        this.money = money;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
