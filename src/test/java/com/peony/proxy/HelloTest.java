package com.peony.proxy;

import com.peony.proxy.proxy.CGlibProxy;
import com.peony.proxy.proxy.DynamicProxy;
import com.peony.proxy.proxy.HelloStaticProxy;
import com.peony.proxy.service.HelloService;
import com.peony.proxy.serviceImpl.HelloServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;


public class HelloTest {

    @Test
    public void testSay(){
        HelloService hello = new HelloServiceImpl();
        hello.sayHello();
    }

    @Test
    public void testStaticProxy(){
        HelloService helloStaticProxy = new HelloStaticProxy();
        helloStaticProxy.sayHello();
    }

    @Test
    public void testDynamicProxy(){
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(helloServiceImpl);
        HelloService helloService = (HelloService)Proxy.newProxyInstance(
                helloServiceImpl.getClass().getClassLoader(),
                helloServiceImpl.getClass().getInterfaces(),
                dynamicProxy
        );
        helloService.sayHello();
    }

    @Test
    public void testDynamicProxyIn(){
        DynamicProxy dynamicProxy = new DynamicProxy(new HelloServiceImpl());
        HelloService proxy = dynamicProxy.getProxy();
        proxy.sayHello();
    }

    @Test
    public void testCGlibProxy(){
        HelloService proxy = CGlibProxy.getInstance().getProxy(HelloServiceImpl.class);
        proxy.sayHello();
    }
}
