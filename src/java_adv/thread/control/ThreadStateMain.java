package java_adv.thread.control;

import java.util.logging.Logger;

import static java_adv.util.MyLogger.log;

public class ThreadStateMain {
    public static void main(String[] args) throws InterruptedException {
        Thread myThread = new Thread(new myRunnable(), "myThread");
        log("myThread.state1 = " + myThread.getState());
        log("myThread.start()");
        myThread.start();
        Thread.sleep(1000);
        log("myThread.state3 = " + myThread.getState());
        Thread.sleep(4000);
        log("myThread.state5 = " + myThread.getState());
        log("end");
    }

    static class myRunnable implements Runnable {

        @Override
        public void run() {
            try {
                log("start");
                log("myRunnable.state2 = " + Thread.currentThread().getState() );

                log("sleep() start");
                Thread.sleep(3000);
                log("sleep() end");

                log("myRunnable.state4 = " + Thread.currentThread().getState());
                log("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
