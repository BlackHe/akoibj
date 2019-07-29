package com.peony.concurrent.automic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 原子类是不使用锁实现并发性的基础
 */
public class AutomicIntegerDemo {

    public static void main(String[] args) {
        CountService countService = new CountService();
        new Thread(countService).start();
        new Thread(countService).start();
        new Thread(countService).start();
        new Thread(countService).start();
        new Thread(countService).start();
    }


    static class CountService implements Runnable {
        private AtomicInteger count = new AtomicInteger(0);

        public void run() {
            for (int i = 0; i < 10000; ++i) {
                System.out.println(count.incrementAndGet());
            }
        }
    }
}
