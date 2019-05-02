package ru.geekbrains.lesson7;

import ru.geekbrains.lesson4.AuthException;
import ru.geekbrains.lesson4.TextMessage;
import ru.geekbrains.lesson7.auth.AuthService;
import ru.geekbrains.lesson7.auth.AuthServiceImpl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import static ru.geekbrains.lesson4.MessagePatterns.AUTH_FAIL_RESPONSE;
import static ru.geekbrains.lesson4.MessagePatterns.AUTH_SUCCESS_RESPONSE;

public class ChatServer {

    private AuthService authService = new AuthServiceImpl();
    private Map<String, ClientHandler> clientHandlerMap = Collections.synchronizedMap(new HashMap<>());
    //private List<String> users;

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        chatServer.start(7777);

    }

    private void start(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server started!");
            while (true) {
                Socket socket = serverSocket.accept();
                DataInputStream inp = new DataInputStream(socket.getInputStream());
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                System.out.println("New client connected!");

                User user = null;
                try {
                    String authMessage = inp.readUTF();
                    user = checkAuthentication(authMessage);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (AuthException ex) {
                    out.writeUTF(AUTH_FAIL_RESPONSE);
                    out.flush();
                    socket.close();
                }
                if (user != null && authService.authUser(user)) {

                    if (clientHandlerMap.containsKey(user.getLogin()) == true){
                        System.out.printf("User %s is already authorized. Access denied!%n", user.getLogin());
                        out.writeUTF(AUTH_FAIL_RESPONSE);
                        out.flush();

                    } else {
                        System.out.printf("User %s authorized successful!%n", user.getLogin());
                        subscribe(user.getLogin(), socket);
                        //whoOnline();
                        out.writeUTF(AUTH_SUCCESS_RESPONSE);
                        out.flush();
                    }
                } else {
                    if (user != null) {
                        System.out.printf("Wrong authorization for user %s%n", user.getLogin());
                        out.writeUTF(AUTH_FAIL_RESPONSE);
                        out.flush();
                        socket.close();
                    }
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private User checkAuthentication(String authMessage) throws AuthException {
        String[] authParts = authMessage.split(" ");
        if (authParts.length != 3 || !authParts[0].equals("/auth")) {
            System.out.printf("Incorrect authorization message %s%n", authMessage);
            throw new AuthException();
        }
        return new User(authParts[1], authParts[2]);
    }

    private void sendUserConnectedMessage(String login) throws IOException {
        for (ClientHandler clientHandler : clientHandlerMap.values()) {
            if (!clientHandler.getLogin().equals(login)) {
                System.out.printf("Sending connect notification to %s about %s%n", clientHandler.getLogin(), login);
                clientHandler.sendConnectedMessage(login);
            }
        }
    }

    private void sendUserDisconnectedMessage(String login) throws IOException {
        for (ClientHandler clientHandler : clientHandlerMap.values()) {
            if (!clientHandler.getLogin().equals(login)) {
                System.out.printf("Sending disconnect notification to %s about %s%n", clientHandler.getLogin(), login);
                clientHandler.sendDisconnectedMessage(login);
            }
        }
    }

    public void sendMessage(TextMessage msg) throws IOException {
        ClientHandler userToClientHandler = clientHandlerMap.get(msg.getUserTo());
        if (userToClientHandler != null) {
            userToClientHandler.sendMessage(msg.getUserFrom(), msg.getText());
        } else {
            System.out.printf("User %s not connected%n", msg.getUserTo());
        }
    }

    public void subscribe(String login, Socket socket) throws IOException {
        clientHandlerMap.put(login, new ClientHandler(login, socket, this));
        sendUserConnectedMessage(login);
    }

    public void unsubscribe(String login) throws IOException {
        clientHandlerMap.remove(login);
        sendUserDisconnectedMessage(login);
    }

/*    public void whoOnline(){
        users = new ArrayList(clientHandlerMap.keySet());
        System.out.println("Users online:" + users);
    }

    public List<String> getUsers() {
        return users;
    }*/

    public List<String> getUsers () {
        return new ArrayList<>(clientHandlerMap.keySet());
    }
}