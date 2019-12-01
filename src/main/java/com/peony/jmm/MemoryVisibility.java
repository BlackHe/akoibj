package com.peony.jmm;

public class MemoryVisibility {

    /**
     * 所谓可见性就是，两个以上的线程在操作同一个状态时，能否及时看到别的线程修改过的最新值；
     * Thread-1  <--->  local work cache
     * Thread-2  <--->  local work cache  <====> main memery
     * Thread-2  <--->  local work cache
     * 反过来说，看不到最新的值就是：线程操作状态时，先将状态读取并保存到线程内部的本地工作缓存中保存一份副本，
     * 后续对该状态的计算，修改，都是在修改本地的副本，等到合适的时机，再跟主内存进行同步，而别的线程能否及时
     * 读取到当前线程的修改，取决于有没有进行过与主内存的同步，因此是不及时的，如果很长时间没有进行同步，就会
     * 导致其他线程表现出错误的行为。
     * volatile修饰，保证了内存可见性，且防止了在变量上操作指令的重排序
     * volatile关键字在Java层面，通过使用内存屏障手段，禁止了工作内存缓存和指令重排序，进而实现了内存可见性
     * 内存屏障的实现由四种，分别是 loadload,loadstore,storeload,storestore;
     * 内存屏障就是线程在该状态上的操作，直接与主内存交互，让线程本地工作缓存"失效"
     */
    private static volatile boolean stopFlag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (!stopFlag){
            }
        }).start();
        Thread.sleep(2000);

        stopFlag = true;
    }
}
