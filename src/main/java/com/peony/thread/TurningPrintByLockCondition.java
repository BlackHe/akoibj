package com.peony.thread;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替输出
 * 即线程1输出 ABCDEFG
 * 线程2输出 123456
 */
public class TurningPrintByLockCondition {

    private final static char[] charsI = {'1', '2', '3', '4', '5', '6'};
    private final static char[] charsC = {'A', 'B', 'C', 'D', 'E', 'F'};

    private static Thread t1, t2;

    private static final ReentrantLock lock = new ReentrantLock();

    private static final Condition c1 = lock.newCondition();
    private static final Condition c2 = lock.newCondition();

    public static void main(String[] args) {
        t1 = new Thread(() -> {
            try {
                lock.lock();
                for (char c : charsC) {
                    try {
                        System.out.print(c);
                        c2.signal();
                        c1.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c2.signal();
            } finally {
                lock.unlock();
            }
        });

        t2 = new Thread(() -> {
            try {

                lock.lock();
                for (char c : charsI) {
                    try {
                        System.out.print(c);
                        c1.signal();
                        c2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                c1.signal();
            } finally {
                lock.unlock();
            }
        });

        t1.start();
        t2.start();
    }

}
