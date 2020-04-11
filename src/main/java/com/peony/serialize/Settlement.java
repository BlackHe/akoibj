package com.peony.serialize;

import java.io.Serializable;

public class Settlement implements Serializable {


    private static final long serialVersionUID = 5425259853988315770L;

    private String orderId;

    private Integer qty;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Settlement{" +
                "orderId='" + orderId + '\'' +
                ", qty=" + qty +
                '}';
    }

    public Settlement(String orderId, Integer qty) {
        this.orderId = orderId;
        this.qty = qty;
    }

    public Settlement() {
    }
}
