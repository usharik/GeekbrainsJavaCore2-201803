package ru.geekbrains.lesson4;

import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
                        TextMessage msg = parseTextMessageRegx(text, login);
                        if (msg != null) {
                            messageReciever.submitMessage(msg);
                            continue;
                        }

                        System.out.println("Connection message " + text);
                        String loginConnected = parseConnectedMessage(text);
                        if (loginConnected != null) {
                            messageReciever.userDisconnected(login);
                            continue;
                        }

                        System.out.println("Disconnection message " + text);
                        String loginDisconected = parseDisconnectedMessage(text);
                        if (loginDisconected != null) {
                            messageReciever.userConnected(login);
                            continue;
                        }

                        // TODO добавить обработку отключения пользователя
                        // DONE


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

            List<String> connectedUsers = requestConnectedUserList();
            if (connectedUsers.size() != 0) {
                messageReciever.allConnectedUsers(connectedUsers);
            }

            receiverThread.start();
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

    public List<String> requestConnectedUserList() throws IOException {
        // TODO реализовать запрос с сервера списка всех подключенных пользователей
        // DONE
        List<String> allConnectedUsersList = new ArrayList<>();

        sendMessage(ALLCONNECTED_USERS);

        String response = in.readUTF();
        //if (!response.isEmpty()) {
            String[] allUsersArrParsed = parseAllConnectedUsersMessage(response);

            for (int i = 1; i < allUsersArrParsed.length; i++) {
                allConnectedUsersList.add(allUsersArrParsed[i]);
            }

            return allConnectedUsersList;
        //} else return null;
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
