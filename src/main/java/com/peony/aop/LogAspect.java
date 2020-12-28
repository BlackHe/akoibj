package com.peony.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.weaver.JoinPointSignature;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(* com.peony.aop.*.*(..))")
    public void pointCut(){

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint){
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            sb.append(",").append(arg);
        }
        System.out.println("时间：["+ Instant.now() +"],请求方法：["+joinPoint.getSignature().toShortString()+"],请求参数：["+sb.toString().substring(1)+"]");
    }

    @After("pointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("后置 切面拦截");
    }

    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public void afterReturn(JoinPoint joinPoint,Object result){
        System.out.println("时间：["+ Instant.now() +"],请求方法：["+joinPoint.getSignature().toShortString()+"],返回值：["+result+"]");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("抛出异常 切面拦截");
    }
}
