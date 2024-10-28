package java_adv2.chat.server.command;

import java_adv2.chat.server.Session;
import java_adv2.chat.server.SessionManager;

import java.io.IOException;
import java.util.List;

public class UsersCommand implements Command {
    private final SessionManager sessionManager;

    public UsersCommand(SessionManager sessionManager) {
        this.sessionManager = sessionManager;
    }

    @Override
    public void execute(String[] args, Session session) throws IOException {
        List<String> usernames = sessionManager.getAllUsernames();
        StringBuilder sb = new StringBuilder();
        sb.append("전체 접속자 : ").append(usernames.size()).append("\n");
        for (String username : usernames) {
            sb.append(" - ").append(username).append("\n");
        }
        session.send(sb.toString());
    }
}
