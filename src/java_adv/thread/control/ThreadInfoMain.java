package java_adv.thread.control;

import java_adv.thread.HelloRunnable;

import static java_adv.util.MyLogger.log;

public class ThreadInfoMain {
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        log("mainThread = " + mainThread);
        log("mainThread.threadId() = " + mainThread.threadId());
        log("mainThread.getName() = " + mainThread.getName());
        log("mainThread.getPriority() = " + mainThread.getPriority());
        log("mainThread.isDaemon() = " + mainThread.isDaemon());
        log("mainThread.getState() = " + mainThread.getState());


        Thread myThread = new Thread(new HelloRunnable(), "myThread");
        log("mainThread = " + myThread);
        log("mainThread.threadId() = " + myThread.threadId());
        log("mainThread.getName() = " + myThread.getName());
        log("mainThread.getPriority() = " + myThread.getPriority());
        log("mainThread.isDaemon() = " + myThread.isDaemon());
        log("mainThread.getState() = " + myThread.getState());
    }
}
