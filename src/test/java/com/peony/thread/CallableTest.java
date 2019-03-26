package com.peony.thread;

import org.junit.Test;

import java.util.concurrent.ExecutorService;

public class CallableTest {

    @Test
    public void callableTest() {
        CallableDemo callable = new CallableDemo();
        String say = callable.say();
        System.out.println("thread name : " + say);

    }
}
