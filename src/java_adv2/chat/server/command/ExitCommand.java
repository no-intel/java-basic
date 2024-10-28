package java_adv2.chat.server.command;

import java_adv2.chat.server.Session;
import java_adv2.chat.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class ExitCommand implements Command {
    private final SessionManager sessionManager;

    public ExitCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        throw new IOException("exit");
    }
}
