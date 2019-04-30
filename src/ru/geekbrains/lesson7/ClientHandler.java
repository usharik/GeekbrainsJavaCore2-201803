package ru.geekbrains.lesson7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static ru.geekbrains.lesson4.MessagePatterns.MESSAGE_SEND_PATTERN;

public class ClientHandler {

    private final String login;
    private final Socket socket;
    private final DataInputStream inp;
    private final DataOutputStream out;
    private final Thread handleThread;
    private ChatServer chatServer;

    public ClientHandler(String login, Socket socket, ChatServer chatServer) throws IOException {
        this.login = login;
        this.socket = socket;
        this.inp = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        this.chatServer = chatServer;

        this.handleThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String msg = inp.readUTF();
                        System.out.printf("Message from user %s: %s%n", login, msg);
                        String [] msgParts = msg.split(" ", 3);
                        String userTo = msgParts[1];
                        String message = msgParts[2];
                        if (msg.startsWith("/w")) {
                            chatServer.sendMessage(userTo, login, message);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        break;
                    }
                }
            }
        });
        this.chatServer = chatServer;
        this.handleThread.start();
    }

    public String getLogin() {
        return login;
    }

    public void sendMessage(String userFrom, String msg) throws IOException {
        out.writeUTF(String.format(MESSAGE_SEND_PATTERN, userFrom, msg));
    }
}
