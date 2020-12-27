package com.peony.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
public class ProductService{


    @Autowired
    private OrderService orderService;


}
