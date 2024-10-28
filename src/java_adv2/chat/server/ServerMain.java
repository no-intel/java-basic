package java_adv2.chat.server;

import java.io.IOException;

public class ServerMain {
    private static final int PORT = 12345;

    public static void main(String[] args) throws IOException {
        SessionManager sessionManager = new SessionManager();
        CommendManager commendManager = new CommendManagerV4(sessionManager);

        Server server = new Server(PORT, commendManager, sessionManager);
        server.start();
    }
}
