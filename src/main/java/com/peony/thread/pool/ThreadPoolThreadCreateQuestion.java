package com.peony.thread.pool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池创建线程的时机
 * 1、默认在实例化线程池时，如果还没有提交任务，不会启动线程的，除非调用了prestartAllCoreThreads
 */
public class ThreadPoolThreadCreateQuestion {

    private static final AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args) {
        // get cpu number
        int cpuNum = Runtime.getRuntime().availableProcessors();
        // thread pool core size best is number of cpu  add 1
        int poolCoreSize = cpuNum + 1;
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                poolCoreSize,
                poolCoreSize + 5,
                10,
                TimeUnit.MINUTES,
                workQueue,
                (r) -> {
                    Thread thread = new Thread(r, "c-" + count.incrementAndGet());
                    System.out.printf("创建了线程【%s】\n", thread.getName());
                    return thread;
                },
                new ThreadPoolExecutor.CallerRunsPolicy()   // 拒绝策略：交给上层调用者执行

        );
        // 创建线程池的时候，如果没有提交任务，则默认是没有启动线程的, 除非调用prestartAllCoreThread
        threadPool.prestartAllCoreThreads();
        // 提交任务的时候也会去创建线程
        threadPool.execute(ActionHolder::action);
        threadPool.execute(ActionHolder::action);
        threadPool.execute(ActionHolder::action);
        threadPool.execute(ActionHolder::action);
    }

    static class ActionHolder {

        public static void action() {
            System.out.printf("提交了任务，线程【%s】正在执行\n", Thread.currentThread().getName());
        }
    }

}
