package java_adv.thread.executor;

import java.util.concurrent.Callable;

import static java_adv.util.MyLogger.log;
import static java_adv.util.ThreadUtils.sleep;

public class CallableTask implements Callable<Integer> {

    private String name;
    private int sleepMs = 100;

    public CallableTask(String name, int sleepMs) {
        this.name = name;
        this.sleepMs = sleepMs;
    }

    public CallableTask(String name) {
        this.name = name;
    }

    @Override
    public Integer call() throws Exception {
        log(name + "실행");
        sleep(sleepMs);
        log(name + "완료");
        return sleepMs;
    }
}
