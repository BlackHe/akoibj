package com.peony.concurrencyinpractice;

/**
 * 内置锁可重入特性验证
 */
public class SynchronizedReentrantQuestion {

    public static void main(String[] args) {
        Widget loggingWidget = new LoggingWidget();
        // 如果synchronized是不可重入的，那么调用super.doSomething()时，由于主线程已经持有了该锁，无法再获取到锁，
        // 从而导致主线程将在此阻塞
        loggingWidget.doSomething();

    }

    static class Widget{
        public synchronized void doSomething(){
            System.out.println("Widget class synchronized method");
        }
    }
    static class LoggingWidget extends Widget{

        @Override
        public synchronized void doSomething() {
            System.out.println("LoggingWidget class synchronized method");
            super.doSomething();
        }
    }

}
