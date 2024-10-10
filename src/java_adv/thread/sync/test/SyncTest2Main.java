package java_adv.thread.sync.test;

import static java_adv.util.MyLogger.log;

public class SyncTest2Main {
    public static void main(String[] args) throws InterruptedException {
        MyCounter counter = new MyCounter();
        Runnable task = new Runnable() {
            public void run() {
                counter.count();
            }
        };

        Thread thread1 = new Thread(task, "t1");
        Thread thread2 = new Thread(task, "t2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    static class MyCounter {
        public void count() {
            int localValue = 0;
            for (int i = 0; i < 10000; i++) {
                localValue ++;
            }
            log("결과: " + localValue);
        }
    }
}
