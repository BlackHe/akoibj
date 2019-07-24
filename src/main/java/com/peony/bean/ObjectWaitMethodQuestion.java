package com.peony.bean;

public class ObjectWaitMethodQuestion {

    private int putIndex;

    private final Object putMonitor = new Object();

    public int netPutIndex() throws InterruptedException {
        synchronized (putMonitor) {
            System.out.printf("线程【%s】持有【%s】对象的锁，此处将其置为“WAITING“状态\n",Thread.currentThread().getName(),putMonitor);
            putMonitor.wait();
            System.out.printf("线程【%s】持有【%s】对象的锁，“WAITING“状态将被唤醒\n",Thread.currentThread().getName(),putMonitor);
            return putIndex++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjectWaitMethodQuestion question = new ObjectWaitMethodQuestion();
        new Thread(() -> {
            try {
                System.out.printf("线程【%s】已启动，将在10秒后唤醒主线程\n",Thread.currentThread().getName());
                synchronized (question.putMonitor){
                    Thread.sleep(10000);
                    question.putMonitor.notifyAll();
                    question.putMonitor.wait();
                }
            }catch (Exception e){
                System.out.printf("唤醒持有对象【%s】的monitor的线程失败,失败原因为：\n【%s】\n",question.putMonitor,e.getMessage());
                e.printStackTrace();
            }
        },"notify-thread").start();
        int index = question.netPutIndex();
        System.out.printf("got putIndex = [%d]\n", index);
    }
}
