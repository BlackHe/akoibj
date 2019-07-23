package com.peony.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {

    public String say() {
        FutureTask<String> futureTask = new FutureTask<String>(new CallableSub());
        Thread thread = new Thread(futureTask);
        thread.start();
        thread.start();
        thread.start();
        thread.start();
        try {
            return futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    class CallableSub implements Callable<String> {
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName());
            return Thread.currentThread().getName();
        }
    }
}
