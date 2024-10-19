package java_adv.thread.executor.future;

import java.util.Random;
import java.util.concurrent.*;

import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class CallableMainV2 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("submit() 호출");
        Future<Integer> future = es.submit(new MyCallable());
        log("future 즉시 반환, future = " + future);

        log("future.get()[블록킹] 메서드 호출 시작 -> main 스레드 waiting");
        Integer result = future.get();
        log("future.get()[블록킹] 메서드 호출 완료 -> main 스레드 runnable");

        log("result value: " + result);
        log("future 완료, future = " + future);
        es.close();

    }

    static class MyCallable implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            log("Callable 시작");
            sleep(2000);
            int value = new Random().nextInt(10);
            log("created value: " + value);
            log("Callable 완료");
            return value;
        }
    }
}
