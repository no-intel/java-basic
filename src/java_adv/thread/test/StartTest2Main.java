package java_adv.thread.test;

import static java_adv.util.MyLogger.log;

public class StartTest2Main {
    public static void main(String[] args) {
        log("main start()");
        new Thread(new CounterThread(), "counter").start();
    }

    static class CounterThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                log("value : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
