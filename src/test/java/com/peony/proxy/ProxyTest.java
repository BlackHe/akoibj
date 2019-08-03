package com.peony.proxy;

import com.peony.code.KeyWorker;
import com.peony.proxy.proxy.CGlibProxy;
import com.peony.proxy.proxy.DynamicProxy;
import com.peony.proxy.proxy.HelloStaticProxy;
import com.peony.proxy.service.HelloService;
import com.peony.proxy.serviceImpl.HelloServiceImpl;
import org.junit.Test;

import java.lang.reflect.Proxy;


public class ProxyTest {

    @Test
    public void testSay() {
        HelloService hello = new HelloServiceImpl();
        hello.sayHello();
    }

    @Test
    public void testStaticProxy() {
        HelloService helloStaticProxy = new HelloStaticProxy();
        helloStaticProxy.sayHello();
    }

    @Test
    public void testDynamicProxy() {
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(helloServiceImpl);
        HelloService helloService = (HelloService) Proxy.newProxyInstance(
                helloServiceImpl.getClass().getClassLoader(),
                /**这个参数导致，被JDK动态代理的类必须要有接口*/
                helloServiceImpl.getClass().getInterfaces(),
                dynamicProxy
        );
        helloService.sayHello();
    }

    @Test
    public void testDynamicProxyIn() {
        DynamicProxy dynamicProxy = new DynamicProxy(new HelloServiceImpl());
        HelloService proxy = dynamicProxy.getProxy();
        proxy.sayHello();
    }

    @Test
    public void testCGlibProxy() {
        HelloServiceImpl proxy = CGlibProxy.getInstance().getProxy(HelloServiceImpl.class);
        System.out.println(proxy.getClass().getName());
        System.out.println(Runtime.getRuntime().availableProcessors());
        proxy.sayHello();
    }

    /**
     * 手动静态代理，无接口实现
     **/
    @Test
    public void testStaticProxyNoInterface() {
        int a = new OrderServiceImpl().count();
        int b = new OrderServiceImplProxy().count();
        System.out.println(a);
        System.out.println(b);
    }

    class OrderServiceImpl {
        int count() {
            return 100;
        }
    }

    class OrderServiceImplProxy {
        int count() {
            OrderServiceImpl service = new OrderServiceImpl();
            return service.count() + 50;
        }
    }


    @Test
    public void testCode() {
        long machineNum = KeyWorker.getMachineNum();
        System.out.println(machineNum);
    }
}
