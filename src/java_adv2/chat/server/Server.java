package java_adv2.chat.server;

import java_adv.util.MyLogger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static java_adv2.util.MyLogger.log;

public class Server {
    private final int port;
    private final CommendManager commendManager;
    private final SessionManager sessionManager;

    private ServerSocket serverSocket;

    public Server(int port, CommendManager commendManager, SessionManager sessionManager) {
        this.port = port;
        this.commendManager = commendManager;
        this.sessionManager = sessionManager;
    }

    public void start() throws IOException {
        log("서버 시작: " + commendManager.getClass());
        serverSocket = new ServerSocket(port);
        log("버서 소켓 시작 - 리스닝 포트: " + port);

        addShutdownHook();
        running();
    }

    private void addShutdownHook() {
        ShutdownHook shutdownHook = new ShutdownHook(serverSocket, sessionManager);
        Runtime.getRuntime().addShutdownHook(new Thread(shutdownHook, "shutdown"));
    }

    private void running() {
        try {
            while (true) {
                Socket socket = serverSocket.accept();
                log("서버 소켓 연결: " + socket);

                Session session = new Session(socket, commendManager, sessionManager);
                Thread thread = new Thread(session);
                thread.start();

            }
        } catch (IOException e) {
            log("서버 소켓 종료: " + e);
        }
    }

    static class ShutdownHook implements Runnable {
        private final ServerSocket serverSocket;
        private final SessionManager sessionManager;

        ShutdownHook(ServerSocket serverSocket, SessionManager sessionManager) {
            this.serverSocket = serverSocket;
            this.sessionManager = sessionManager;
        }

        @Override
        public void run() {
            MyLogger.log("shutdown hook 실행");
            try {
                sessionManager.closeAll();
                serverSocket.close();

                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("e = " + e);
            }
        }
    }
}
