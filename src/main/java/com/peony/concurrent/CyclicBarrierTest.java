package com.peony.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {



    public static void main(String[] args) {

        CyclicBarrier barrier = new CyclicBarrier(5);

        new Thread(() -> {
            try {
                System.out.println("线程1准备中。。。");
                sleep(1);
                barrier.await();
                System.out.println("线程1准备完成，go on");
                System.out.println("线程1结束任务");
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(() -> {
            try {
                System.out.println("线程2准备中。。。");
                sleep(2);
                barrier.await();
                System.out.println("线程2准备完成，go on");
                System.out.println("线程2结束任务");
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        },"t2").start();
    }

    public static void sleep(long seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
