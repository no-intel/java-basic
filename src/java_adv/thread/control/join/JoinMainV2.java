package java_adv.thread.control.join;

import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class JoinMainV2 {
    public static void main(String[] args) {
        log("start");
        sumTask task1 = new sumTask(0, 50);
        sumTask task2 = new sumTask(51, 100);
        Thread thread1 = new Thread(task1, "T1");
        Thread thread2 = new Thread(task2, "T2");
        thread1.start();
        thread2.start();

        log("main 스레드 sleep()");
        sleep(3000);
        log("main 스레드 꺠어남");

        log("task1.result = " + task1.result);
        log("task2.result = " + task2.result);
        log("end");
    }

    static class sumTask implements Runnable {
        private int startValue;
        private int endValue;
        public int result;

        public sumTask(int min, int max) {
            this.startValue = min;
            this.endValue = max;
        }

        @Override
        public void run() {
            log("작업시작");
            int sum = 0;
            for (int i = startValue; i < endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);
        }
    }
}
