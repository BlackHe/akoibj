package com.peony.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    public void say() {
        ExecutorService excutor = Executors.newFixedThreadPool(5);
        excutor.submit(new Runnable() {
            public void run() {
                System.out.println("thread name : " + Thread.currentThread().getName());
            }
        });
        excutor.shutdown();

    }
}
