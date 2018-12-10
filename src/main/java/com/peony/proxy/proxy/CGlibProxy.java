package com.peony.proxy.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGlib动态代理
 * 优点：被代理的对象可以没有接口
 */
public class CGlibProxy implements MethodInterceptor {

    private static CGlibProxy cGlibProxy = new CGlibProxy();

    private CGlibProxy(){};

    public static CGlibProxy getInstance(){
        return cGlibProxy;
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(o, objects);
        after();
        return result;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls){
        return (T)Enhancer.create(cls,this);
    }

    private void before(){
        System.out.println("I'm before......... and I from CGlibProxy");
    }

    private void after(){
        System.out.println("I'm after ..........and I from CGlibProxy");
    }
}
