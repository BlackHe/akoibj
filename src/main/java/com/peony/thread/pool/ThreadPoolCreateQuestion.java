package com.peony.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolCreateQuestion {

    public static void main(String[] args) {
        ExecutorService threadPool = getThreadPool();
        threadPool.execute(ThreadPoolCreateQuestion::printState);
        threadPool.shutdown();
    }

    public static ExecutorService getThreadPool() {
        ExecutorService threadPool = new ThreadPoolExecutor(
                5,
                10,
                30,
                TimeUnit.MINUTES,
                new LinkedBlockingQueue<Runnable>());
        return threadPool;
    }

    private static void printState() {
        System.out.printf("线程【%s】正在执行,当前的线程状态是【%s】", Thread.currentThread().getName(), Thread.currentThread().getState());

    }
}
