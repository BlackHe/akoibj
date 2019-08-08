package com.peony.synctoos;

/**
 * volatile关键字
 * 1.避免用volatile修饰的字段涉及到的操作指令被重排序
 * 2.保证内存可见性，即当有个多线程操作volatile修饰的变量时，读线程能及时获取到写线程修改过后最新的值
 * 3.是一种轻量级的锁实现
 */
public class VolatileQuestion {

    volatile static boolean beforeTaskFinished = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            try {
                Thread.sleep(100);
                beforeTaskFinished = true;
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }).start();
        while (!beforeTaskFinished) {
            doSomeThingBefore();
        }
        doSomeThingAfter();
    }

    private static void doSomeThingBefore() throws InterruptedException {
        System.out.println("正在执行前置任务...");
    }

    private static void doSomeThingAfter() throws InterruptedException {
        System.out.println("前置任务已执行完...执行后续任务");
    }
}
