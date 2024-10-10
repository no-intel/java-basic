package java_adv.thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class LockSupportMainV1 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "t1");
        thread1.start();

        sleep(100);
        log("t1 state: " + thread1.getState());

        log("main -> unpark(t1)");
        LockSupport.unpark(thread1);
//        thread1.interrupt();
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.park();
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
