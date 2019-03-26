package com.peony.concurrent.trans;

public class TransDemo {

    public static void main(String[] args) {
        MyList list = new MyList();
        new Thread(new ServiceA(list)).start();
        new Thread(new ServiceB(list)).start();
    }


    static class ServiceA implements Runnable {
        private MyList list;

        public ServiceA(MyList list) {
            this.list = list;
        }

        public void run() {
            try {
                for (; ; ) {
                    if (list.size() == 8) {
                        System.out.println("list.size == 8, exit....");
                        throw new InterruptedException("list.size == 8了");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    static class ServiceB implements Runnable {
        private MyList list;

        public ServiceB(MyList list) {
            this.list = list;
        }

        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    list.add("hewx");
                    System.out.println("添加了" + (i + 1) + "个元素");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
