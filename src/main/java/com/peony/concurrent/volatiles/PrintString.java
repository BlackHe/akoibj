package com.peony.concurrent.volatiles;

/**
 *
 */
public class PrintString {

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
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * stop order disable in here, because thread 'main' executing bad while cycle in print(),
     *
     * @param args
     */
    public static void main(String[] args) {
        PrintString printService = new PrintString();
        printService.print();
        System.out.println("stop print now...");
        printService.setCoutinue(false);
    }
}
