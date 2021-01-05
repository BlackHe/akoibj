package com.peony.thread;

import com.peony.log.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 两个线程交替输出[A1B2C3D4E5G6]
 * 即线程1输出 ABCDEFG
 * 线程2输出 123456
 */
public class TurningPrintByReentrantLock {

    static volatile AtomicInteger nextPrintIndex = new AtomicInteger();
    static char[] charArray = "A1B2C3D4E5G6".toCharArray();

    static ReentrantLock lock = new ReentrantLock(true);

    static CountDownLatch latch = new CountDownLatch(1);

    public static void main(String[] args) {
        Thread workerA = new Thread(new PrintWorkerA());
        Thread workerB = new Thread(new PrintWorkerB());
        workerA.start();
        workerB.start();
        try {
            workerA.join();
            workerB.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    static class PrintWorkerA implements Runnable {

        boolean isFrist = true;

        public void run() {

            while (nextPrintIndex.get() < charArray.length - 1) {
                try {
                    lock.lock();
                    if (isFrist) {
                        isFrist = false;
                        latch.countDown();
                    }
                    Log.info("%s --------> %s ", Thread.currentThread().getName(), charArray[nextPrintIndex.get()] + "");
                    nextPrintIndex.getAndIncrement();
                } finally {
                    lock.unlock();
                }

            }


        }

    }

    static class PrintWorkerB implements Runnable {

        public void run() {

            try {
                latch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (nextPrintIndex.get() < charArray.length) {
                try {
                    lock.lock();
                    Log.info("%s -> %s ", Thread.currentThread().getName(), charArray[nextPrintIndex.get()] + "");
                    nextPrintIndex.getAndIncrement();
                } finally {
                    lock.unlock();
                }

            }

        }

    }

}
