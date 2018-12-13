package com.peony.concurrent;

/**
 * 验证static,synchronized 修饰的方法，一定是线程安全的
 * 因为这二者修饰的方法，默认使用了T.class 作为锁对象，当该类编译后，class对象是全局唯一的
 * 就算是多个线程，都在使用T.class这一把锁，故安全
 */
public class StaticSyncMethodDemo {

    public static synchronized void print(){
        System.out.println("....test...........begin...........");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("....test............end............");
    }

    static class SafeThread extends Thread{
        @Override
        public void run() {
            StaticSyncMethodDemo.print();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 4; ++i){
            new SafeThread().start();
        }
    }
}
