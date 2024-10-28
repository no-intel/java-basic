package java_adv2.chat.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static java_adv.util.MyLogger.log;
import static java_adv2.network.tcp.SocketCloseUtil.closeAll;

public class Session implements Runnable{
    private final Socket socket;
    private final DataInputStream input;
    private final DataOutputStream output;
    private final CommendManager commendManager;
    private final SessionManager sessionManager;

    private boolean closed = false;
    private String username;

    public Session(Socket socket,CommendManager commendManager, SessionManager sessionManager) throws IOException {
        this.socket = socket;
        this.input = new DataInputStream(socket.getInputStream());
        this.output = new DataOutputStream(socket.getOutputStream());
        this.commendManager = commendManager;
        this.sessionManager = sessionManager;
        this.sessionManager.add(this);
    }

    @Override
    public void run() {
        try {
            while (true) {
                String received = input.readUTF();
                log("client -> server:" + received);

                commendManager.execute(received, this);
            }
        } catch (IOException e) {
            log(e);
        } finally {
            sessionManager.remove(this);
            sessionManager.sendAll(username + "님이 퇴장 했습니다.");
            close();
        }
    }

    public void send(String message) throws IOException {
        log("server -> client:" + message);
        output.writeUTF(message);
    }


    public synchronized void close() {
        if (closed) {
            return;
        }
        closeAll(socket, input, output);
        closed = true;
        log("연결 종료: " + socket);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
