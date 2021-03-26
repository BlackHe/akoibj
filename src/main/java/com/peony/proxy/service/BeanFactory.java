package com.peony.proxy.service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.math.BigDecimal;

public class BeanFactory {
    private static final BeanFactory factory = new BeanFactory();

    public static BeanFactory getInstance(){
        return factory;
    }

    public Object getBean(Class tClass){
        Object proxyInstance = Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new Class[]{tClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("method=" + method);
                System.out.println("args=" + args);
                OrderVO orderVO = new OrderVO();
                orderVO.setId("R01290");
                orderVO.setAmount(new BigDecimal("77.0099"));
                return orderVO;
            }
        });
        return proxyInstance;
    }

    class MyInvocationHandler implements InvocationHandler{

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return null;
        }
    }
}
