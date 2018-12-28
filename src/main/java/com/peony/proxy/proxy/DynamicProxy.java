package com.peony.proxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 * 优点：省去了写很多xxxProxy.java类的代码
 * 缺点：被代理的对象必须要有至少一个接口
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(Object targetObj) {
        this.target = targetObj;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target,args);
        after();
        return result;
    }

    private void before(){
        System.out.println("I'm before.........");
    }

    private void after(){
        System.out.println("I'm after ..........");
    }

     
     @SuppressWarnings("unchecked")
     public  <T> T getProxy(){
        return (T)Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }
}
