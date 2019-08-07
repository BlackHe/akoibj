package com.peony.synctoos;

/**
 * volatile关键字
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
