package com.peony.concurrent;

public class SyncCodeBlockDemo {
    private final static Object objLock = new Object(); //线程 安全 的锁对象
    private static Object objLock1 = new Object();      //线程 安全 的锁对象
    private final  Object objLock2 = new Object();      //线程  不安全  的锁对象
    private Object objLock3 = new Object();             //线程  不安全  的锁对象

    /**
     *  //使用自定义的对象锁
     * @throws InterruptedException
     */
    public void useCustObjLock() throws InterruptedException{
        synchronized (objLock3){
            System.out.println("test.......begin.........");
            Thread.sleep(100);
            System.out.println("test........end.........");
        }
    }

    /**
     * 使用this(调用者)对象锁
     * @throws InterruptedException
     */
    public void useThisLock() throws InterruptedException{
        synchronized (this){
            System.out.println("test.......begin.........");
            Thread.sleep(100);
            System.out.println("test........end.........");
        }
    }

    /**
     * 使用T.class对象锁
     * @throws InterruptedException
     */
    public void useClassLock() throws InterruptedException{
        synchronized (SyncCodeBlockDemo.class){
            System.out.println("test.......begin.........");
            Thread.sleep(100);
            System.out.println("test........end.........");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; ++i){
            new SubThread().start();
        }
    }

   static class SubThread extends Thread{
        @Override
        public void run() {
            SyncCodeBlockDemo demo = new SyncCodeBlockDemo();
            try {
//                demo.useCustObjLock();   //使用自定义的对象锁（不一定安全，看自定义对象是不是static的）
//                demo.useThisLock();     //使用this对象锁（不一定安全，看怎么调用了）
                demo.useClassLock();    //使用class对象锁（一定安全）
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
