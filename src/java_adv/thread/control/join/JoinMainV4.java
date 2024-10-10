package java_adv.thread.control.join;

import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class JoinMainV4 {
    public static void main(String[] args) throws InterruptedException {
        log("start");
        sumTask task1 = new sumTask(0, 50);
        Thread thread1 = new Thread(task1, "T1");
        thread1.start();

        log("join() - main 대기");
        thread1.join(1000);
        log("join() - main 대기완료");

        log("task1.result = " + task1.result);
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
            sleep(2000);
            int sum = 0;
            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }
            result = sum;
            log("작업 완료 result = " + result);
        }
    }
}
