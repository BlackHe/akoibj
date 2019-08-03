package com.peony.synctoos;

import java.util.concurrent.CountDownLatch;

/**
 * 同步工具类之-闭锁-ContDownLatch
 */
public class CountDownLatchQuestion {

    public static void main(String[] args) throws InterruptedException{

        long l = timeTasks(10, () -> {
            System.out.printf("线程【%s】正在执行任务\n", Thread.currentThread().getName());
        });
        System.out.println(l);
    }

    public static long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);
        // 创建n个任务，并发执行任务task
        for (int i = 0; i < nThreads; i++) {
            Thread thread = new Thread(() -> {
                try {
                    // 所有线程在这里等待，知道主线程发枪
                    startGate.await();
                    try {
                        // 发枪后同时开始并发的执行任务
                        task.run();
                    } finally {
                        // 执行完任务后，全部都递减闭锁计数器
                        endGate.countDown();
                    }
                } catch (InterruptedException ignored) {

                }
            });
            thread.start();
        }
        // n个线程并发执行任务线开始计时
        long start = System.nanoTime();
        // 启动门使得主线程能够同时释放所有工作的线程
        startGate.countDown();
        // 结束门使得主线程能够等待最后一个线程执行完成，而不是顺序的等待每个线程执行完成
        endGate.await();
        // 所有线程并发执行完任务后，停止计时
        long end = System.nanoTime();
        // n个线程并发执行完task任务的共耗时
        long timeCost = end - start;
        return timeCost;
    }
}
