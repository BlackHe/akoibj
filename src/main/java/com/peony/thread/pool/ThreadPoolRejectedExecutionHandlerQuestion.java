package com.peony.thread.pool;

import java.util.concurrent.*;

/**
 * 线程池拒绝策略
 * 有四种
 * 1、丢弃任务且抛出异常
 * 2、丢弃任务，但不抛出异常
 * 3、丢弃队列最前面的任务，然后尝试重新执行任务
 * 4、由调用线程处理该任务
 *
 */
public class ThreadPoolRejectedExecutionHandlerQuestion {

    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>(1000);
        new ThreadPoolExecutor(
                5,       // 核心线程数
                10,  // 最大线程数
                10,     // 空闲线程存活时间
                TimeUnit.MINUTES,   // 空闲线程存活时间单位
                workQueue,          // BlockQueue   任务队列
                (r) -> {
                    return new Thread(r);
                },                  // ThreadFactory    线程创建工厂
                new ThreadPoolExecutor.CallerRunsPolicy()  // 拒绝策略
        );
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
}
