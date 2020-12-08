package com.peony.lock.condition;

import com.peony.log.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockQueue {

    private volatile List<Runnable> tasks = new ArrayList<>(10);

    private Lock mainLock = new ReentrantLock();

    // 消费者消费条件：任务队列不为空
    private Condition notNull = mainLock.newCondition();

    // 生产者生产条件：任务队列不满
    private Condition notFull = mainLock.newCondition();


    public boolean put(Runnable task){

        mainLock.lock();
        try {
            while (tasks.size() >= 10){
                notNull.signal();
                try {
                    notFull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.info("生产：线程【%s】。任务队列已满，通知【消费者】消费，阻塞【生产者】生产",Thread.currentThread().getName());
            }
            tasks.add(task);
            notNull.signal();
            Log.info("生产：线程【%s】。通知【消费者】消费",Thread.currentThread().getName());
            return true;
        }finally {
            mainLock.unlock();
        }
    }

    public Runnable take(){
        mainLock.lock();
        try{
            while (tasks.size() == 0){
                notFull.signal();
                try {
                    notNull.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.info("消费while：队列任务数量【%s】",tasks.size()+"");
                Log.info("消费：线程【%s】。通知【生产者】，阻塞【消费者】",Thread.currentThread().getName());
                return tasks.remove(0);
            }
            Log.info("队列任务数量【%s】",tasks.size()+"");
            Runnable result = tasks.remove(0);
            notFull.signal();
            Log.info("消费：线程【%s】。通知【生产者】",Thread.currentThread().getName());
            return result;
        }finally {
            mainLock.unlock();
        }
    }
}
