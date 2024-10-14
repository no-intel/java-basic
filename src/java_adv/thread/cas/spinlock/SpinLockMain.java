package java_adv.thread.cas.spinlock;

import static java_adv.util.MyLogger.log;

public class SpinLockMain {
    public static void main(String[] args) {
//        SpinLockBad spinLock = new SpinLockBad();
        SpinLock spinLock = new SpinLock();

        Runnable task = new Runnable() {

            @Override
            public void run() {
                spinLock.lock();
                try {
                    log("비즈니스 로직 실행");
                } finally {
                    spinLock.unlock();
                }
            }
        };

        Thread thread1 = new Thread(task, "t1");
        Thread thread2 = new Thread(task, "t2");

        thread1.start();
        thread2.start();
    }
}
