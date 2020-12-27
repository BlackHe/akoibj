package com.peony.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
public class OrderService implements InitializingBean , ApplicationContextAware {

    @Autowired
    private ProductService productService;

    public OrderService() {
        System.out.println("OrderService 实例化了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("after Properties Set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("aware...");
    }
}
