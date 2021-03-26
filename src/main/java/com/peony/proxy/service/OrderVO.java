package com.peony.proxy.service;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderVO {


    private String id;

    private BigDecimal amount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "OrderVO{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                '}';
    }
}
