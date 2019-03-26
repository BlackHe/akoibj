package com.peony.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationConfig.xml");
        Order Order = (Order) factory.getBean("order");
        /**非web应用中，优雅的关闭spring IOC容器*/
        ((ClassPathXmlApplicationContext) factory).registerShutdownHook();
    }
}
