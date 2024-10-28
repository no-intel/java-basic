package java_adv2.chat.server;

import java_adv2.chat.server.command.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CommendManagerV4 implements CommendManager {
    private static final String DELIMITER = "\\|";;
    private final Map<String, Command> commands = new HashMap<>();
    private final Command defaultCommand = new DefaultCommand();

    public CommendManagerV4(SessionManager sessionManager) {
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
        Command command = commands.getOrDefault(key, defaultCommand);
        command.execute(args, session);
    }
}
