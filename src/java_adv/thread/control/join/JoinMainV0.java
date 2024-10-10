package java_adv.thread.control.join;

import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class JoinMainV0 {
    public static void main(String[] args) {
        log("start");
        Thread thread1 = new Thread(new Job(), "T1");
        Thread thread2 = new Thread(new Job(), "java_adv.thread.test.StartTest2Main");
        thread1.start();
        thread2.start();
        log("end");
    }

    static class Job implements Runnable {

        @Override
        public void run() {
            log("작업시작");
            sleep(2000);
            log("작업끝");
        }
    }
}
