package java_adv.thread.executor.poolsize;

import java_adv.thread.executor.RunnableTask;

import java.util.concurrent.*;

import static java_adv.thread.executor.ExecutorUtils.printState;
import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class PoolSizeMainV4 {
//    static final int TASK_SIZE = 1100;
//    static final int TASK_SIZE = 1200;
    static final int TASK_SIZE = 1201;


    public static void main(String[] args) {
//        ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = new ThreadPoolExecutor(100, 200,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1000));

        printState(es);

        long startMs = System.currentTimeMillis();
        for (int i = 0; i < TASK_SIZE; i++) {
            String taskName = "task" + i;
            try {
                es.execute(new RunnableTask(taskName));
                printState(es, taskName);
            } catch (RejectedExecutionException e) {
                log(taskName + " -> " + e);
            }
        }
        es.close();
        long endMs = System.currentTimeMillis();
        log("time: " + (endMs - startMs));
    }
}
