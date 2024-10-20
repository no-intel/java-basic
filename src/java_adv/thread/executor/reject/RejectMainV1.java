package java_adv.thread.executor.reject;

import java_adv.thread.executor.RunnableTask;

import java.util.concurrent.*;

import static java_adv.util.MyLogger.log;

public class RejectMainV1 {
    public static void main(String[] args) {
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
                new SynchronousQueue<>(), new ThreadPoolExecutor.AbortPolicy());
        executor.submit(new RunnableTask("task1"));
        try {
            executor.submit(new RunnableTask("task2"));
        }catch (RejectedExecutionException e) {
            log("요청 초과");
            log(e);
        }

        executor.close();
    }
}
