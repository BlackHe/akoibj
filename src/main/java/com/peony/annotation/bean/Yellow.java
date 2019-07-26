package com.peony.annotation.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


public class Yellow implements  BeanPostProcessor, ApplicationContextAware {

    private ApplicationContext applicationContext;

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Yellow class postProcessBeforeInitialization....");
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Yellow class postProcessAfterInitialization....");
        return bean;
    }

    @Override
    public String toString() {
        System.out.println("this is yellow class toString()...");
        return Yellow.class.getName();
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
