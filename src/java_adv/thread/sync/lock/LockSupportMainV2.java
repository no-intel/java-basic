package java_adv.thread.sync.lock;

import java.util.concurrent.locks.LockSupport;

import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class LockSupportMainV2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new ParkTest(), "t1");
        thread1.start();

        sleep(100);
        log("t1 state: " + thread1.getState());
    }

    static class ParkTest implements Runnable {

        @Override
        public void run() {
            log("park 시작");
            LockSupport.parkNanos(2_000_000_000);
            log("park 종료, state: " + Thread.currentThread().getState());
            log("인터럽트 상태: " + Thread.currentThread().isInterrupted());
        }
    }
}
