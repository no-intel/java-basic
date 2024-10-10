package java_adv.thread.test;

import static java_adv.util.MyLogger.log;

public class StartTest5Main {
    public static void main(String[] args) {
        log("main start()");
        PrintWork a = new PrintWork("A", 1000);
        PrintWork b = new PrintWork("B", 500);
        new Thread(a, "Thread-A").start();
        new Thread(b, "Thread-B").start();
        log("main end()");
    }

    static class PrintWork implements Runnable {
        private String content;
        private int sleepMs;

        public PrintWork(String content, int sleepMs) {
            this.content = content;
            this.sleepMs = sleepMs;
        }

        @Override
        public void run() {
            while(true) {
                log(content);
                try {
                    Thread.sleep(sleepMs);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
