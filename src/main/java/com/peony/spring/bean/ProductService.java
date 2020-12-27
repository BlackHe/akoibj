package com.peony.spring.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements InitializingBean {


    @Autowired
    private OrderService orderService;


    public ProductService() {
        System.out.println("produceService 实例化了..");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("produceService after Properties Set..");
    }
}
