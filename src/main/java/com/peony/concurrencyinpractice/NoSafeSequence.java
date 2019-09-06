package com.peony.concurrencyinpractice;

/**
 * 线程不安全的序列生成器
 *
 * i++ 操作不是原子操作
 * 这是 读取-修改-写入 三个操作的指令集合
 * 在多线程情况下，会由于不恰当的执行时序而出现不正确的结果，这就是：【竞态条件】
 * 正确的结果要取决于运气
 */
public class NoSafeSequence {

    private int nextValue;

    public int getNext(){
        return nextValue++;
    }
}
