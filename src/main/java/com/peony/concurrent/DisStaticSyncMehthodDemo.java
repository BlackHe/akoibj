package com.peony.concurrent;

/**
 * 验证 非static，synchronozed 修饰的方法，线程不一定安全
 */
public class DisStaticSyncMehthodDemo {
    /**
     * 线程不一定安全,如果在多线程环境下，调用此方法的不是同一个对象，就说明每个线程持有的都是不同对象的锁，同步无从谈起
     * 调用者要注意
     */

    public synchronized void print() throws InterruptedException{
        System.out.println("test.......begin.........");
        Thread.sleep(100);
        System.out.println("test........end.........");
    }


    public static void main(String[] args) {
        /**
         * 1.线程安全的用法：用 disStaticSync作为锁对象，下面的4个线程都是使用这个对象作为锁对象，所以是安全的
         */
        DisStaticSyncMehthodDemo disStaticSync = new DisStaticSyncMehthodDemo();
        for (int i = 0; i < 4; ++i){
            new SafeThread(disStaticSync).start();
        }
        /**
         * 2.线程不安全的用法：4个线程启动时创建了4个不同的DisStaticSyncMehthodDemo对象
         *  而非static的，有synchronized修饰的方式，默认的锁对象是当前调用者对象，可见4个线程new了4个对象作为调用者，每个线程持有的锁都不同，
         *  所以线程不安全
         */
        for (int i = 0; i < 4; ++i){
            new NoSafeThread().start();
        }
    }


    static class SafeThread extends Thread {
        private DisStaticSyncMehthodDemo analyze;
        public SafeThread(DisStaticSyncMehthodDemo para) {
            analyze = para;
        }
        @Override
        public void run() {
            try {
                analyze.print();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }

    static class NoSafeThread extends Thread{
        @Override
        public void run() {
            DisStaticSyncMehthodDemo demo = new DisStaticSyncMehthodDemo();
            try {
                demo.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
