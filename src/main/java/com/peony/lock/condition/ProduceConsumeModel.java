package com.peony.lock.condition;

import java.util.concurrent.CountDownLatch;

public class ProduceConsumeModel {

    public static void main(String[] args) {
        MyBlockQueue myBlockQueue = new MyBlockQueue();

        for (int i = 0; i < 10; ++i) {
            new Thread(() -> {
                myBlockQueue.put(() -> {
                    System.out.println("任务x");
                });
            }, "produce-" + i).start();

            new Thread(() -> {
                Runnable task = myBlockQueue.take();
                task.run();
            }, "consume-" + i).start();
        }


    }


}
