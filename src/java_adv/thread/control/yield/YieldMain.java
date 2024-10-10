package java_adv.thread.control.yield;

import static java_adv.util.ThreadUtils.sleep;

public class YieldMain {
    static final int THREAD_COUNT = 1000;

    public static void main(String[] args) {
        for (int i = 0; i < THREAD_COUNT; i++) {
            new Thread(new MyRunnable()).start();
        }
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " - " + i);
                // 1. empty
//                sleep(1);
                 Thread.yield();
            }
        }
    }
}
