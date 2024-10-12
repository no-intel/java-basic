package java_adv.thread.bounded;

import java.util.ArrayList;
import java.util.List;

import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class BoundedMain {

    public static void main(String[] args) {
        BoundedQueue queue = new BoundedQueueV6_4(2);

//        producerFirst(queue);
        consumerFirst(queue);
    }

    private static void consumerFirst(BoundedQueue queue) {
        log("==[소비자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + "==");
        ArrayList<Thread> threads = new ArrayList<>();
        startConsumer(queue, threads);
        printAllstate(queue, threads);

        startProducer(queue, threads);
        printAllstate(queue, threads);
        log("==[소비자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + "==");
    }

    private static void producerFirst(BoundedQueue queue) {
        log("==[생상자 먼저 실행] 시작, " + queue.getClass().getSimpleName() + "==");
        ArrayList<Thread> threads = new ArrayList<>();
        startProducer(queue, threads);
        printAllstate(queue, threads);

        startConsumer(queue, threads);
        printAllstate(queue, threads);
        log("==[생상자 먼저 실행] 종료, " + queue.getClass().getSimpleName() + "==");
    }



    private static void startProducer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        log("생산 시작");
        for (int i = 1; i <= 3; i++) {
            Thread producer = new Thread(new ProducerTask(queue, "data" + i), "producer" + i);
            threads.add(producer);
            producer.start();
            sleep(100);
        }
    }

    private static void startConsumer(BoundedQueue queue, ArrayList<Thread> threads) {
        System.out.println();
        log("소비자 시작");
        for (int i = 1; i <= 3; i++) {
            Thread consumer = new Thread(new ConsumerTask(queue), "consumer" + i);
            threads.add(consumer);
            consumer.start();
            sleep(100);
        }
    }

    private static void printAllstate(BoundedQueue queue, ArrayList<Thread> threads) {
        System.out.println();
        log("현재 상태 출력, 큐 데이터: " + queue);
        for (var thread : threads) {
            log(thread.getName() + ": " + thread.getState());
        }
    }
}
