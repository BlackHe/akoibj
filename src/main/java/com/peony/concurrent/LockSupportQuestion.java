package com.peony.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class LockSupportQuestion {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        LinkedBlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>(2);
        blockingQueue.add("23");
        blockingQueue.add("443");
        blockingQueue.add("44534");

//        while (true){
//            service.execute( () -> {
//                System.out.println(Thread.currentThread().getName()+" is running..");
//                try {
//                    TimeUnit.MILLISECONDS.sleep(200);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
    }
}
