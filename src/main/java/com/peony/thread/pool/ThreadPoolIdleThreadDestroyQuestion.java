package com.peony.thread.pool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池-闲置线程-销毁问题
 */
public class ThreadPoolIdleThreadDestroyQuestion {
    public static void main(String[] args) {
        int cpuNumber = Runtime.getRuntime().availableProcessors();
        new ThreadPoolExecutor(
                cpuNumber+1,
                cpuNumber+6,
                30,
                TimeUnit.SECONDS,
                );
    }
}
