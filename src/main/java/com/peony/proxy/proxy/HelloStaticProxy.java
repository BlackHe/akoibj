package com.peony.proxy.proxy;

import com.peony.proxy.service.HelloService;
import com.peony.proxy.service.OrderVO;
import com.peony.proxy.serviceImpl.HelloServiceImpl;

/**
 * 代理模式---之静态代理
 * 缺点：每个需要代理的类，都需要写一个xxxProxy.java类，代码臃肿
 * 静态代理helloServiceImpl
 */
public class HelloStaticProxy implements HelloService {

    private HelloServiceImpl helloService;

    public HelloStaticProxy() {
        this.helloService = new HelloServiceImpl();
    }

    public void sayHello() {
        before();
        this.helloService.sayHello();
        after();
    }


    @Override
    public OrderVO createOrder(OrderVO param) {
        return null;
    }

    private void before() {
        System.out.println("I'm before.........");
    }

    private void after() {
        System.out.println("I'm after ..........");
    }
}
