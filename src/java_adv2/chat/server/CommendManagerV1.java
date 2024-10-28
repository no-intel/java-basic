package java_adv2.chat.server;

import java.io.IOException;

public class CommendManagerV1 implements CommendManager {
    private final SessionManager sessionManager;

    public CommendManagerV1(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        if (totalMessage.startsWith("/exit")) {
            throw new IOException("exit");
        }

        sessionManager.sendAll(totalMessage);
    }
}
