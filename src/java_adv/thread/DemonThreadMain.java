package java_adv.thread;

public class DemonThreadMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");
        DemonThread demonThread = new DemonThread();
        demonThread.setDaemon(true);
        demonThread.start();
        System.out.println(Thread.currentThread().getName() + ": main() start");
    }
}
