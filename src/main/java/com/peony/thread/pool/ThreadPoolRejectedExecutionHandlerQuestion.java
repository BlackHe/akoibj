package com.peony.thread.pool;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程池拒绝策略
 * 有四种
 * 1、丢弃任务且抛出异常
 * 2、丢弃任务，但不抛出异常
 * 3、丢弃队列最前面的任务，然后尝试重新执行任务
 * 4、由调用线程处理该任务
 * 任务爆满时的处理机制，线程创建时机
 */
public class ThreadPoolRejectedExecutionHandlerQuestion {

    private static final AtomicInteger count = new AtomicInteger(0);
    private static final int WORK_QUEUE_SIZE = 1300;
    private static final BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(WORK_QUEUE_SIZE);

    public static void main(String[] args) throws InterruptedException {
        // blockqueue的add方法，元素入队时，如果队列已满，会直接报错，抛出IllegalStateException异常，提示queue full
        workQueue.add(ActionHolder::action);
        workQueue.add(ActionHolder::action);
        workQueue.add(ActionHolder::action);
        workQueue.add(ActionHolder::action);
        workQueue.add(ActionHolder::action);
        workQueue.add(ActionHolder::action);
        workQueue.add(ActionHolder::action);
        workQueue.add(ActionHolder::action);
        workQueue.add(ActionHolder::action);
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                10,       // 核心线程数
                12,  // 最大线程数
                1,     // 空闲线程存活时间
                TimeUnit.SECONDS,   // 空闲线程存活时间单位
                workQueue,          // BlockQueue   任务队列
                (r) -> {
                    Thread thread = new Thread(r, "c" + count.decrementAndGet());
                    System.out.printf("构建了一个线程【%s】\n", thread.getName());
                    return thread;
                },                  // ThreadFactory    线程创建工厂
                new ThreadPoolExecutor.CallerRunsPolicy()  // 拒绝策略-交给上层调用者处理多余任务
        );
        System.out.println("activeCount =>" + threadPool.getActiveCount());
        threadPool.execute(ActionHolder::action);
//        threadPool.execute(ActionHolder :: action);
//        threadPool.execute(ActionHolder :: action);
//        threadPool.execute(ActionHolder :: action);
        System.out.println("activeCount =>" + threadPool.getActiveCount());
        for (int i = 0; i < 1000; i++) {
            workQueue.add(ActionHolder::action);
        }
        threadPool.shutdown();
    }

    static class Commision implements Runnable {
        @Override
        public void run() {

        }
    }

    static class ThreadCreator implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }

    static class ActionHolder {
        public static void action() {
            System.out.printf("正在执行任务，当前的线程是【%s】\n", Thread.currentThread().getName());
        }
    }
}
