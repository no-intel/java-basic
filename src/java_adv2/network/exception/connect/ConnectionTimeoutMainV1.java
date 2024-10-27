package java_adv2.network.exception.connect;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

public class ConnectionTimeoutMainV1 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        try {
            new Socket("192.168.1.250", 45678);
        } catch (ConnectException e) {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println("end = " + (end - start));
    }
}
