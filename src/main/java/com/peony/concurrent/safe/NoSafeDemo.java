package com.peony.concurrent.safe;

public class NoSafeDemo{


    public static void main(String args[]){
        CountThread thread1 = new CountThread();
        Thread a = new Thread(thread1,"A");
        Thread b = new Thread(thread1,"B");
        Thread c = new Thread(thread1,"C");
        Thread d = new Thread(thread1,"D");
        Thread e = new Thread(thread1,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    static class CountThread extends Thread{
        private int count = 5;
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count--;
            System.out.println("由 "+Thread.currentThread().getName()+" 运算，count="+count);
        }
    }
}
