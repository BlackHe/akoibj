package com.peony.concurrent.safe;

/**
 * 线程死锁
 * <p>
 * 线程1持有对象A的锁，在等待对象B的锁，与此同时，
 * 线程2持有对象B的锁，在等待对象A的锁，
 * 这样就发生了死锁
 * <p>
 * 通过jstack -l threadId,就能看到JVM监控信息
 * Java stack information for the threads listed above:
 * ===================================================
 * "Thread-1":
 * at com.peony.concurrent.safe.DealThread$SubThread.run(DealThread.java:47)
 * - waiting to lock <0x00000000d8519588> (a java.lang.Object)
 * - locked <0x00000000d8519598> (a java.lang.Object)
 * at java.lang.Thread.run(Thread.java:748)
 * "Thread-0":
 * at com.peony.concurrent.safe.DealThread$SubThread.run(DealThread.java:35)
 * - waiting to lock <0x00000000d8519598> (a java.lang.Object)
 * - locked <0x00000000d8519588> (a java.lang.Object)
 * at java.lang.Thread.run(Thread.java:748)
 */
public class DealThread {

    public static void main(String[] args) throws InterruptedException {
        SubThread subThread = new SubThread();
        subThread.setUseName("a");
        new Thread(subThread).start();
        Thread.sleep(100);
        subThread.setUseName("b");
        new Thread(subThread).start();

    }


    static class SubThread implements Runnable {
        private String useName;
        public Object lock1 = new Object();
        public Object lock2 = new Object();

        public void setUseName(String useName) {
            this.useName = useName;
        }

        public void run() {
            if (useName.equals("a")) {
                synchronized (lock1) {
                    System.out.println("useName = a .... lock1 --> lock2");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("useName = b .... lock1 --> lock2 --> lock2..");
                    }
                }
            } else if (useName.equals("b")) {
                synchronized (lock2) {
                    System.out.println("useName = b .... lock2 --> lock1");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("useName = b .... lock2 --> lock1 --> lock1....");
                    }
                }
            }
        }
    }
}
