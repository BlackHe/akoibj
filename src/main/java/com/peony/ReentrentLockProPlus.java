package com.peony;


import com.peony.utils.Sleeper;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ReentrentLockProPlus {

    private volatile Thread currentHolder;

    private volatile int state = 0;


    private long timeout = 1L;

    private AtomicInteger lockCounter = new AtomicInteger(0);

    Node head;
    Node tail;




    public void lock(){
        System.out.println(Thread.currentThread().getName() + " get lock");
        if (currentHolder == Thread.currentThread()){
            state += 1;
        }

        if (lockCounter.compareAndSet(0,1)){
            currentHolder = Thread.currentThread();
            state += 1;
            return ;
        }

        if (head == null){
            head = new Node(Thread.currentThread());
            tail = head;
        }else {
            tail.next = new Node(Thread.currentThread());
        }
        System.out.println(Thread.currentThread().getName() + "未获取锁失败，阻塞并进入等待队列");
        LockSupport.park(Thread.currentThread());
        System.out.println(Thread.currentThread().getName() + "被唤醒");
        lock();
    }



    public static void main(String[] args) {
        ReentrentLockProPlus lockProPlus = new ReentrentLockProPlus();

        new Thread(() ->{
            lockProPlus.lock();
            System.out.println(Thread.currentThread().getName() + "获取到了锁");
            Sleeper.sleep(2);
            lockProPlus.unLock();
            System.out.println(Thread.currentThread().getName() + "释放了锁");
        }).start();

        new Thread(() ->{
            System.out.println(Thread.currentThread().getName() + "等待锁");
            lockProPlus.lock();
            System.out.println(Thread.currentThread().getName() + "获取到了锁");
            lockProPlus.unLock();
            System.out.println(Thread.currentThread().getName() + "释放了锁");
        }).start();

        Sleeper.sleep(20000);
    }


    public void unLock(){
        System.out.println(Thread.currentThread().getName() + " release lock");
        if (state == 0){
            throw new RuntimeException("lock was not used");
        }
        if (state > 0){
            if (currentHolder != Thread.currentThread()){
                throw new RuntimeException("lock holder not self");
            }
            state -= 1;
            lockCounter.compareAndSet(1,0);
            if (state == 0){
                currentHolder = null;
            }
        }
        if (head != null){
            System.out.println("唤醒" + head.waitThread);
            LockSupport.unpark(head.waitThread);
            head = head.next;
        }

    }

    class Node{
        Thread waitThread;
        Node next;

        public Node(Thread waitThread) {
            this.waitThread = waitThread;
        }
    }

}
