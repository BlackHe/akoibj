package com.peony.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class ProductService{


    @Autowired
    private OrderService orderService2;

    @Autowired
    private OrderService orderService1;

    public OrderService getOrderService2() {
        return orderService2;
    }
    public OrderService getOrderService1() {
        return orderService1;
    }

}
