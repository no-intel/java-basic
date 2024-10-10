package java_adv.thread;

import static java_adv.util.MyLogger.log;

public class InnerRunnableMainV4 {
    public static void main(String[] args) {
        log("main() start");

        new Thread(() -> log("run()")).start();

        log("main() end");
    }
}
