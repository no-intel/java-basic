package java_adv.thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;

import static java_adv.util.MyLogger.log;

public class BoundedQueueV6_2 implements BoundedQueue {

    private final ArrayBlockingQueue<String> queue;

    public BoundedQueueV6_2(int max) {
        this.queue = new ArrayBlockingQueue<>(max);
    }

    @Override
    public void put(String data) {
        boolean result = queue.offer(data);
        log("저장 시도 결과 = " + result);
    }

    @Override
    public String take() {
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
