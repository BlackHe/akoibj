package com.peony.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class LogAspect {

    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final ThreadLocal<Instant> LOCAL_RUNNING_INSTANT = new ThreadLocal<>();

    @Pointcut("execution(* com.peony.aop.*.*(..))")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        LOCAL_RUNNING_INSTANT.set(Instant.now());
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            if (arg instanceof int[]) {
                int[] iargs = (int[]) arg;
                String s = "";
                for (int iarg : iargs) {
                    s = s + iarg + "|";
                }
                sb.append(",").append(s);
            } else {
                sb.append(",").append(arg);
            }
        }
        System.out.println("[" + Thread.currentThread().getName() + "]时间：[" + DTF.format(LocalDateTime.now()) + "],请求方法：[" + joinPoint.getSignature().toShortString() + "],请求参数：[" + sb.toString().substring(1) + "]");
    }

    //    @After("pointCut()")
    public void after(JoinPoint joinPoint) {
//        System.out.println("后置 切面拦截");
    }

    @AfterReturning(pointcut = "pointCut()", returning = "result")
    public void afterReturn(JoinPoint joinPoint, Object result) {
        Instant begin = LOCAL_RUNNING_INSTANT.get();
        LOCAL_RUNNING_INSTANT.remove();
        Long cost = Instant.now().toEpochMilli() - begin.toEpochMilli();
        System.out.println("[" + Thread.currentThread().getName() + "]时间：[" + DTF.format(LocalDateTime.now()) + "],请求方法：[" + joinPoint.getSignature().toShortString() + "],返回值：[" + result + "],执行耗时：[" + cost + "]毫秒");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("抛出异常 切面拦截");
    }
}
