package ru.geekbrains.lesson4;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;

import static ru.geekbrains.lesson4.MessagePatterns.*;

public class Network implements Closeable {

    public Socket socket;
    public DataInputStream in;
    public DataOutputStream out;

    private String hostName;
    private int port;
    private MessageReciever messageReciever;

    private String login;

    private Thread receiverThread;

    public Network(String hostName, int port, MessageReciever messageReciever) {
        this.hostName = hostName;
        this.port = port;
        this.messageReciever = messageReciever;

        this.receiverThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        String text = in.readUTF();

                        System.out.println("New message " + text);
                        TextMessage msg = parseText(text, login);
                        if (msg != null) {
                            switch (msg.getMessageType()) {
                                case MESSAGE_PREFIX:
                                    messageReciever.submitMessage(msg);
                                    continue;
                                case CONTACTS:
                                    System.out.println("Contact list : " + text);
                                    messageReciever.refreshContacts(Arrays.asList(msg.getText().substring(1,msg.getText().length()-1).split(", ")));
                                    continue;
                                case CONNECTED:
                                    System.out.println("Connection message " + text);
                                    requestConnectedUserList();
                                    continue;
                                case DISCONNECT:
                                    System.out.println("Disconnection message " + text);
                                    requestConnectedUserList();
                                    continue;
                            }
                        }

                        // добавить обработку отключения пользователя
                    } catch (IOException e) {
                        e.printStackTrace();
                        if (socket.isClosed()) {
                            break;
                        }
                    }
                }
            }
        });
    }

    public void authorize(String login, String password) throws IOException, AuthException {
        socket = new Socket(hostName, port);
        out = new DataOutputStream(socket.getOutputStream());
        in = new DataInputStream(socket.getInputStream());

        sendMessage(String.format(AUTH_PATTERN, login, password));
        String response = in.readUTF();
        if (response.equals(AUTH_SUCCESS_RESPONSE)) {
            this.login = login;
            receiverThread.start();
            requestConnectedUserList();
        } else {
            throw new AuthException();
        }
    }

    public void sendTextMessage(TextMessage message) {
        sendMessage(String.format(MESSAGE_SEND_PATTERN, message.getUserTo(), message.getText()));
    }

    private void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void requestConnectedUserList() throws IOException {
        // реализовать запрос с сервера списка всех подключенных пользователей
        sendMessage(String.format(CONTACTS));
    }

    public String getLogin() {
        return login;
    }

    @Override
    public void close() {
        this.receiverThread.interrupt();
        sendMessage(DISCONNECT);
    }
}
