package java_adv.thread.test;

import static java_adv.util.MyLogger.log;

public class StartTest4Main {
    public static void main(String[] args) {
        log("main start()");
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                log("value : " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "counter").start();
    }
}
