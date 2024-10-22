package java_adv2.io.start;

import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PrintStreamMain {
    public static void main(String[] args) {
        System.out.println("hello");

        byte[] bytes = "Hello!\n".getBytes(UTF_8);
        PrintStream printStream = System.out;
        printStream.println(new String(bytes, UTF_8));
        printStream.println("Print!");

    }
}
