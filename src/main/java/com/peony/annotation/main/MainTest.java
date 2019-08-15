package com.peony.annotation.main;

import com.peony.annotation.bean.Dog;
import com.peony.annotation.configuration.MainConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(MainConfig.class);
        Object dataSource = acac.getBean("dataSource");
//        System.out.printf(dataSource);
        String[] beanDefinitionNames = acac.getBeanDefinitionNames();
        for (String name : beanDefinitionNames){
            System.out.printf(name + "\n");
        }
    }
}
