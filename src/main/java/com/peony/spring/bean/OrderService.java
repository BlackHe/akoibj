package com.peony.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

//@Component
public class OrderService {


    public OrderService() {
        System.out.println("orderService construct...");
    }

    @Autowired
    private ProductService productService;


    public ProductService getProductService() {
        return productService;
    }
}
