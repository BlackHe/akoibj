package com.peony.thread.interrupt;

import com.peony.log.Log;
import com.peony.utils.Sleeper;

public class TestThread {



    public static void main(String[] args) {

        Thread thread01 = new Thread(new TaskA(),"THREAD-01");
        thread01.start();
        Sleeper.sleep(2);
        Log.info("主线程将THREAD-01 中断");
        thread01.interrupt();
        for (int i = 0; i < 100; i++) {
            Sleeper.sleep(1);
            Log.info("主线程还在执行");
        }


    }

    static class TaskA implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                Log.info("task execute: "+ i);
                if (Thread.currentThread().isInterrupted()){
                    Log.info("%s线程相应中断，终止执行",Thread.currentThread().getName());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Log.info("线程【%s】出现中断异常...\n"+Thread.currentThread().getName());
                    Log.info(e.getMessage());
                    Log.info("%s线程相应中断，终止执行",Thread.currentThread().getName());
                    break;
                }
            }
        }
    }

    class TaskB implements Runnable{
        @Override
        public void run() {
            for (int i = 0; i < 100; i++) {
                System.out.println("taskB execute: "+ i);
            }
        }
    }
}
