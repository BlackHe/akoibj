package com.peony.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.peony.aop")
public class MainConfig {


    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(MainConfig.class);
//        Calculator calculator = ac.getBean("simpleCalculator", Calculator.class);
        Calculator calculator = ac.getBean(Calculator.class);

        new Thread(() -> calculator.add(823,9283,-9238,9),"my-thread1").start();
        new Thread(() -> calculator.subtraction(823,9283),"my-thread2").start();
        new Thread(() -> calculator.add(0,0,1),"my-thread3").start();
    }


}
