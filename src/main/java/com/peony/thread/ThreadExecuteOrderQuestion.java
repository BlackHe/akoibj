package com.peony.thread;

import java.util.concurrent.TimeUnit;

/**
 * 线程执行顺序
 */
public class ThreadExecuteOrderQuestion {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("start run mutil thread");
        Thread t1 = new Thread(() -> {
            System.out.printf("线程【%s】正在执行,当前线程的优先级是【%s】\n", Thread.currentThread().getName(), Thread.currentThread().getPriority());
        }, "1");
        Thread t2 = new Thread(() -> {
            System.out.printf("线程【%s】正在执行,当前线程的优先级是【%s】\n", Thread.currentThread().getName(), Thread.currentThread().getPriority());
        }, "2");
        Thread t3 = new Thread(ThreadExecuteOrderQuestion::run, "3");
        Thread t4 = new Thread(ThreadExecuteOrderQuestion::run, "4");
        t1.setPriority(1);
        t2.setPriority(3);
        t3.setPriority(7);
        t4.setPriority(10);
        t1.start();
        t1.join();
        Thread.sleep(10000);
        t2.start();
        t2.join();
        t3.start();
        t3.join();
        t4.start();
        t4.join();
        System.out.printf("线程【%s】正在执行,当前线程的优先级是【%s】\n", Thread.currentThread().getName(), Thread.currentThread().getPriority());
    }

    private static void run() {
        System.out.printf("线程【%s】正在执行,当前线程的优先级是【%s】\n", Thread.currentThread().getName(), Thread.currentThread().getPriority());

    }
}
