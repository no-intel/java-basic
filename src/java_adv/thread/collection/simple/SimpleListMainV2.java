package java_adv.thread.collection.simple;

import java_adv.thread.collection.simple.list.BasicList;
import java_adv.thread.collection.simple.list.SimpleList;
import java_adv.thread.collection.simple.list.SyncList;
import java_adv.thread.collection.simple.list.SyncProxyList;

import static java_adv.util.MyLogger.log;

public class SimpleListMainV2 {
    public static void main(String[] args) throws InterruptedException {
//        test(new BasicList());
//        test(new SyncList());
        test(new SyncProxyList(new BasicList()));

    }

    private static void test(SimpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());

        Runnable addA = new Runnable() {

            @Override
            public void run() {
                list.add("a");
                log("T1: list.add(A)");
            }
        };

        Runnable addB = new Runnable() {

            @Override
            public void run() {
                list.add("b");
                log("T2: list.add(B)");
            }
        };

        Thread thread1 = new Thread(addA, "t1");
        Thread thread2 = new Thread(addB, "t2");

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log(list);
    }
}
