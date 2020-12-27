package com.peony.spring.configuration_demo;

import com.peony.spring.bean.OrderService;
import org.springframework.context.annotation.Bean;

//@Configuration
public class BeanConfiguration {

//    @Bean
    public OrderService orderService(){
        return new OrderService();
    }
}
