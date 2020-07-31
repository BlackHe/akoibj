package com.peony.bean;

import org.springframework.beans.factory.FactoryBean;

public class OrderFactoryBean implements FactoryBean<Order> {
    @Override
    public Order getObject() throws Exception {
        return new Order();
    }

    @Override
    public Class<?> getObjectType() {
        return Order.class;
    }
}
