package com.peony.serialize;

import java.io.Serializable;

public class Settlement implements Serializable {


    private static final long serialVersionUID = 5425259853988315770L;

    private String orderId;

    private Integer qty;

    private String remark;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Settlement{" +
                "orderId='" + orderId + '\'' +
                ", qty=" + qty +
                ", remark='" + remark + '\'' +
                '}';
    }

    public Settlement(String orderId, Integer qty) {
        this.orderId = orderId;
        this.qty = qty;
    }

    public Settlement() {
    }
}
