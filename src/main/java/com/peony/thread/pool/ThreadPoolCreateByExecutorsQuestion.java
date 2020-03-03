package com.peony.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
//import java.util.concurrent.Executors;

// 静态导包 since 1.54
import static java.util.concurrent.Executors.*;

/**
 * 通过Executors获取线程池
 */
public class ThreadPoolCreateByExecutorsQuestion {

    public static void main(String[] args) {
        // 创建一个具有固定数量的线程池
        ExecutorService threadPool1 = newFixedThreadPool(5);

        // 创建一个最大整数值的线程池，没有corePoolSize,空闲60s销毁空闲线程
        ExecutorService threadPool2 = newCachedThreadPool();

        // 创建只有一个线程的线程池，永久存在，
        ExecutorService threadPool3 = newSingleThreadExecutor();

        // 创建一个 核心线程=5，maximum = Integer.MAX的线程池
        ScheduledExecutorService threadPool4 = newScheduledThreadPool(5);
    }
}
