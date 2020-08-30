package com.peony.thread.threadlocal;

public class Demo {


    private String name;


    private static ThreadLocal<Demo> tl = new ThreadLocal<>();

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

        tl.set(new Demo(Thread.currentThread().getName()));

        t1 = new Thread(() -> {
            tl.set(new Demo(Thread.currentThread().getName()));
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1: " + tl.get());
        }, "t1");

        t2 = new Thread(() -> {
            tl.set(new Demo(Thread.currentThread().getName()));
            System.out.println("t2: " + tl.get());
        }, "t2");

        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main: " + tl.get());
    }
}
