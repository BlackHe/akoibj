package com.peony.spring;

import com.peony.spring.bean.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan
@PropertySource("resource.properties")
public class MyApplication {

    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MyApplication.class);
        System.out.println(ac.getBean(OrderService.class));
    }
}
