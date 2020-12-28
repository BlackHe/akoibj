package com.peony.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.peony.aop")
public class MainAspect {


    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainAspect.class);
//        Calculator calculator = ac.getBean("simpleCalculator", Calculator.class);
        Calculator calculator = ac.getBean(Calculator.class);
        int add = calculator.add(1, 4);

    }


}
