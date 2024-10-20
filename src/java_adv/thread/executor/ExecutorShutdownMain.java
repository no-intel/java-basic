package java_adv.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java_adv.thread.executor.ExecutorUtils.printState;
import static java_adv.util.MyLogger.log;

public class ExecutorShutdownMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new RunnableTask("taskA"));
        es.execute(new RunnableTask("taskB"));
        es.execute(new RunnableTask("taskC"));
        es.execute(new RunnableTask("longTask", 100_000));
        printState(es);

        log("== shutdown 시작");
        shutdownAndAwaitTermination(es);
        log("== shutdown 완료");
        printState(es);
    }

    private static void shutdownAndAwaitTermination(ExecutorService es) {
        es.shutdown();
        try {
            if (!es.awaitTermination(10, TimeUnit.SECONDS)){
                log("서비스 정산 종료 실패 -> 강제 종료 시도");
                es.shutdownNow();
                if (!es.awaitTermination(10, TimeUnit.SECONDS)){
                    log("서비스가 종료되지 않았습니다.");
                }
            }
        } catch (InterruptedException e) {
            es.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
