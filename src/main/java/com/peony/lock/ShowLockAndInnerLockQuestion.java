package com.peony.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 显示锁和内置锁问题
 * 显示锁：Lock接口的实现类，最常用的就是ReentrantLock,ReentrantReadWriteLock
 * 内置锁：synchronized
 */
public class ShowLockAndInnerLockQuestion {

    public static void main(String[] args) {
        executeUseInnerLock();
        System.out.println("======================");
        executeUseShowLock();
    }

    /**
     * 使用显示锁
     * 公平/非公平
     * 可重入
     */
    public static void executeUseShowLock() {
        // 非公平锁，也是默认的锁，性能更高
        // 考虑为什么更高（省去了唤醒线程的时间）
        Lock nonFairLock = new ReentrantLock(false);
        nonFairLock.lock();
        System.out.println("lock");
        try {
            action("使用显示锁实现线程安全");
        } catch (Exception e) {
            System.out.printf("遇到异常[%s]\n", e.getCause());
        } finally {
            // 显示锁的定时炸弹，如果不关闭锁，则这个锁将一直存在,如果一旦出现问题，这个炸弹爆炸，则很难发现发生
            // 错误的地方，因为没有记录当时应当释放锁的位置
            // 这也是ReentranLock不能完全替代synchronized的主要原因
            System.out.println("unlock");
            nonFairLock.unlock();
        }
    }


    /**
     * 使用内置锁
     * 非公平锁
     * 可重入
     */
    public static void executeUseInnerLock() {
        synchronized (ShowLockAndInnerLockQuestion.class) {
            action("使用内置锁实现线程安全");
        }
    }

    public static void action(String s) throws RuntimeException {
        System.out.println(s);
    }
}
