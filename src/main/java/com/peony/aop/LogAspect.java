package com.peony.aop;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.peony.aop.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(){
        System.out.println("前置 切面拦截");
    }

    @After("pointCut()")
    public void after(){
        System.out.println("后置 切面拦截");
    }

    @AfterReturning("pointCut()")
    public void afterReturn(){
        System.out.println("方法返回 切面拦截");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("抛出异常 切面拦截");
    }
}
