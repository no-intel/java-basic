package java_adv.thread;

import static java_adv.util.MyLogger.log;

public class ManyThreadMain1 {
    public static void main(String[] args) {
        log("main() start");

        HelloRunnable helloRunnable = new HelloRunnable();

        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(helloRunnable);
            thread.start();
        }
        log("main()) end");
    }
}
