package java_adv2.chat.server;

import java_adv2.chat.server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommendManagerV3 implements CommendManager {
    private static final String DELIMITER = "\\|";;
    private final Map<String, Command> commands = new HashMap<>();

    public CommendManagerV3(SessionManager sessionManager) {
        commands.put("/join", new JoinCommand(sessionManager));
        commands.put("/message", new MessageCommand(sessionManager));
        commands.put("/exit", new ExitCommand(sessionManager));
        commands.put("/users", new UsersCommand(sessionManager));
        commands.put("/change", new ChangeCommand(sessionManager));
    }

    @Override
    public void execute(String totalMessage, Session session) throws IOException {
        String[] args = totalMessage.split(DELIMITER);
        String key = args[0];
        Command command = commands.get(key);
        if (command == null) {
            session.send("처리할 수 없는 명령어 입니다: " + totalMessage);
            return;
        }
        command.execute(args, session);
    }
}
