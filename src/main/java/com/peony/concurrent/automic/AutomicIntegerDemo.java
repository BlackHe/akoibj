package com.peony.concurrent.automic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类是不使用锁实现并发性的基础
 */
public class AutomicIntegerDemo {

    public static void main(String[] args) throws InterruptedException {
        CountService countService = new CountService();
        Thread thread1 = new Thread(countService);
        thread1.start();
        thread1.join();

        Thread thread2 = new Thread(countService);
        thread2.start();
        thread2.join();

        Thread thread3 = new Thread(countService);
        thread3.start();
        thread3.join();

        Thread thread4 = new Thread(countService);
        thread4.start();
        thread4.join();

        Thread thread5 = new Thread(countService);
        thread5.start();
        thread5.join();

        System.out.println(CountService.count.get());

    }


    static class CountService implements Runnable {
        static AtomicInteger count = new AtomicInteger(0);

        public void run() {
            for (int i = 0; i < 100; ++i) {
                System.out.printf("线程【%s】正在操作自增,当前自增后的结果值是【%d】\n", Thread.currentThread().getName(), count.incrementAndGet());
            }
        }
    }
}
