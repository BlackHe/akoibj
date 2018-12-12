package com.peony.concurrent;

/**
 * synchronized（内置锁，同步锁）
 * 分析其锁原理，线程处理机制
 */
public class SynchronizedAnalyze {

    public synchronized int  sum(){
        return 1;
    }

    public int count(){
        return 2;
    }
}
