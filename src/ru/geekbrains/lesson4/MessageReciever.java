package ru.geekbrains.lesson4;

import java.util.List;

public interface MessageReciever {

    void submitMessage(TextMessage message);

    void userConnected(String login);

    void userDisconnected(String login);

    void allConnectedUsers(List<String> logins);
}
