package java_adv.thread;

import static java_adv.util.MyLogger.log;

public class InnerRunnableMainV1 {
    public static void main(String[] args) {
        log("main() start");
        MyHelloRunnable myHelloRunnable = new MyHelloRunnable();
        new Thread(myHelloRunnable).start();
        log("main() end");
    }

    static class MyHelloRunnable implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + ": run()");
        }
    }

}
