package com.peony.spring.configuration_demo;

import com.peony.spring.bean.OrderService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class BeanConfiguration {

    @Bean
    public OrderService orderService1(){
        return new OrderService();
    }

    @Bean
    public OrderService orderService2(){
        return new OrderService();
    }
}
