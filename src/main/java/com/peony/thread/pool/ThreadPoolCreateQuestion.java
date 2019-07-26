package com.peony.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolCreateQuestion {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadPool = getThreadPool();
        threadPool.execute(ThreadPoolCreateQuestion::printState);
        threadPool.shutdown();
    }

    public static ExecutorService getThreadPool() throws InterruptedException {
        // create one task queue of capcity is thress, add three task to the queue;
        BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<Runnable>();
        for (int i = 0; i < 100000; i++) {
            tasks.add(() -> {
                System.out.printf("task-[%d] was executed..by thread [%s]\n", 1, Thread.currentThread().getName());
            });
        }
//        tasks.add(() -> {
//            System.out.printf("task-[%d] was executed..by thread [%s]\n",2,Thread.currentThread().getName());
//        });
//        tasks.add(() -> {
//            System.out.printf("task-[%d] was executed..by thread [%s]\n",3,Thread.currentThread().getName());
//        });
        // create one thread pool of core pool size is five, add task to the pool;
        ExecutorService threadPool = new ThreadPoolExecutor(
                5,
                10,
                30,
                TimeUnit.MINUTES,
                tasks
        );
        return threadPool;
    }

    private static void printState() {
        System.err.printf("线程【%s】正在执行,当前的线程状态是【%s】\n", Thread.currentThread().getName(), Thread.currentThread().getState());
    }
}
