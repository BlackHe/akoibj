package com.peony.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationConfig.xml");
        TestBean testBean = (TestBean)factory.getBean("testBean");
        System.out.println(testBean.getCreateTime());
    }
}
