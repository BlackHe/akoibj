package com.peony.concurrent.volatiles;

/**
 *
 */
public class PrintStringThread implements Runnable{

    private boolean isCoutinue = true;

    public boolean isCoutinue() {
        return isCoutinue;
    }

    public void setCoutinue(boolean coutinue) {
        isCoutinue = coutinue;
    }

    public void print() {
        try {
            while (isCoutinue) {
                System.out.println("run print threadName=" + Thread.currentThread().getName());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        print();
    }

    /**
     * stop order work fine in here when we use <code>Thread<code/>,
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        PrintStringThread printService = new PrintStringThread();
        new Thread(printService).start();
        Thread.sleep(5000);
        System.out.println("stop print now...");
        printService.setCoutinue(false);
    }
}
