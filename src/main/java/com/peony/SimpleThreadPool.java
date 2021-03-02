package com.peony;

import java.io.IOException;
import java.util.concurrent.ArrayBlockingQueue;

public class SimpleThreadPool {


    private static ArrayBlockingQueue<Runnable> taskQueue = new ArrayBlockingQueue<>(1000);


    static {
        Executor.getExecutor().start();
        Executor.getExecutor().start();
        Executor.getExecutor().start();
    }

    public static void submit(Runnable runnable){
        taskQueue.offer(runnable);
    }

    private static class Executor extends Thread{

        @Override
        public void run() {
            Runnable task;
            while ((task = taskQueue.poll()) != null ){
                task.run();
            }
        }

        static Executor getExecutor(){
            return new Executor();
        }
    }


    public static void main(String[] args) throws IOException {
        SimpleThreadPool.submit(() -> {
            System.out.println(666 + Thread.currentThread().getName());
        });
        SimpleThreadPool.submit(() -> {
            System.out.println(666 + Thread.currentThread().getName());
        });
        SimpleThreadPool.submit(() -> {
            System.out.println(666 + Thread.currentThread().getName());
        });
        SimpleThreadPool.submit(() -> {
            System.out.println(666 + Thread.currentThread().getName());
        });

        System.in.read();
    }



}
