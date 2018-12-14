package com.peony.concurrent.safe;

/**
 * i-- 操作并非是线程安全的，因为被编译后生成了三条字节码指令，多线程下这三条指令的执行并非是原子的
 * 先取得i的值
 * 计算i-1
 * 对i进行赋值
 * <p>
 * <p>
 * 2: getfield      #2                  // Field n:I
 * 5: iconst_1
 * 6: iadd
 * 7: putfield      #2                  // Field n:I
 *
 * 可以将i--操作进行同步，最小锁粒度，synchronized(){}代码块
 *
 * 4: monitorenter
 * 5: aload_0
 * 6: dup
 * 7: getfield      #2                  // Field n:I
 * 10: iconst_1
 * 11: iadd
 * 12: putfield      #2                  // Field n:I
 * 15: aload_1
 * 16: monitorexit
 */
public class NoSafeDemo {


    public static void main(String args[]) {
        CountThread thread1 = new CountThread();
        Thread a = new Thread(thread1, "A");
        Thread b = new Thread(thread1, "B");
        Thread c = new Thread(thread1, "C");
        Thread d = new Thread(thread1, "D");
        Thread e = new Thread(thread1, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }

    static class CountThread extends Thread {
        private int count = 5;

        @Override
        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (CountThread.class) {
                count--;
                System.out.println("由 " + Thread.currentThread().getName() + " 运算，count=" + count);
            }
        }
    }
}
