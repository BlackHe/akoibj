package com.peony.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolCreateQuestion {


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPool = getThreadPool();

        threadPool.allowCoreThreadTimeOut(true);
        threadPool.execute(ThreadPoolCreateQuestion::printState);
        sleepSeconds(1);
        threadPool.execute(ThreadPoolCreateQuestion::printState);
        sleepSeconds(1);
        threadPool.execute(ThreadPoolCreateQuestion::printState);
        sleepSeconds(1);
        threadPool.execute(ThreadPoolCreateQuestion::printState);
        sleepSeconds(1);
        threadPool.execute(ThreadPoolCreateQuestion::printState);
        sleepSeconds(1);
        threadPool.execute(ThreadPoolCreateQuestion::printState);
        sleepSeconds(1);
        threadPool.execute(ThreadPoolCreateQuestion::printState);
        sleepSeconds(1);
        threadPool.execute(ThreadPoolCreateQuestion::printState);
        sleepSeconds(1);

        threadPool.shutdown();
    }

    public static ThreadPoolExecutor getThreadPool() throws InterruptedException {
        // create one task queue of capcity is thress, add three task to the queue;
        BlockingQueue<Runnable> tasks = new LinkedBlockingQueue<Runnable>();
        for (int i = 0; i < 3; i++) {
            tasks.add(() -> {
                System.out.printf("init... task-[%d] was executed..by thread [%s]\n", 1, Thread.currentThread().getName());
            });
        }
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
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

    private static void sleepSeconds(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
