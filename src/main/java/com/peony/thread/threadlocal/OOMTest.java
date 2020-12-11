package com.peony.thread.threadlocal;

import com.peony.log.Log;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class OOMTest {

    private static ThreadLocal<byte[]> tl = new ThreadLocal<>();
    private static ThreadLocal<String> t2 = new ThreadLocal<>();

    static int one_m = 1024*1024;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(1);
        CountDownLatch countDownLatch = new CountDownLatch(1);

        Thread thread1 = new Thread(() -> {
            semaphore.release();
            Log.info("semaphoore release 1");
            countDownLatch.countDown();

            blockOnReadIn();
            semaphore.release();
            Log.info("semaphoore release 2");

            blockOnReadIn();
            semaphore.release();
            Log.info("semaphoore release 3");

            blockOnReadIn();
            semaphore.release();
            Log.info("semaphoore release 4");
        });
        thread1.start();
        try {
            countDownLatch.await();
            semaphore.acquire();
            Log.info("semaphoore acquire 1");
            semaphore.acquire();
            Log.info("semaphoore acquire 2");
            semaphore.acquire();
            Log.info("semaphoore acquire 3");
            semaphore.acquire();
            Log.info("semaphoore acquire 4");
            semaphore.acquire();
            Log.info("semaphoore acquire 5");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        tl.set(new byte[1*one_m]);
//        tl.remove();
//        byte[] bytes = new byte[1];


    }

    public static void sleep(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void blockOnReadIn(){
        try {
            int read = System.in.read();
            Log.info("释放了["+read+"]个许可");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
