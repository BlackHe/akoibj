package com.peony.thread.threadlocal;

public class Demo {


    private String name;


    private static ThreadLocal<Demo> localSession = new ThreadLocal<>();

    private static ThreadLocal<Demo> connectCtx = new ThreadLocal<>();

    public Demo(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                '}';
    }

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {

        localSession.set(new Demo(Thread.currentThread().getName()+"-的线程本地会话"));

        connectCtx.set(new Demo(Thread.currentThread().getName()+"-的数据库连接"));

        t1 = new Thread(() -> {
            localSession.set(new Demo(Thread.currentThread().getName()));
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1: " + localSession.get().name);
        }, "t1");

        t2 = new Thread(() -> {
            localSession.set(new Demo(Thread.currentThread().getName()+"-的线程本地会话"));
            System.out.println("t2: " + localSession.get().name);
        }, "t2");

        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main: " + localSession.get().name);
        System.out.println("main: " + connectCtx.get().name);
    }
}
