package java_adv.thread;

public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ": main() start");

        HelloThread helloThread = new HelloThread();
        new Thread(helloThread).start();

        System.out.println(Thread.currentThread().getName() + ": main() end");
    }
}
