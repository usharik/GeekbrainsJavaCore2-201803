package ru.geekbrains.lesson4.swing;

import ru.geekbrains.lesson4.MessageReciever;
import ru.geekbrains.lesson4.Network;
import ru.geekbrains.lesson4.TextMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements MessageReciever {

    private final JList<TextMessage> messageList;

    private final DefaultListModel<TextMessage> messageListModel;

    private final TextMessageCellRenderer messageCellRenderer;

    private final JScrollPane scroll;

    private final JPanel sendMessagePanel;

    //private final JTextField userToField; //поле, где указываем кому отправляем сообщение

    private final JButton sendButton;

    private final JTextField messageField;

    private final Network network;

    public MainWindow() {
        setTitle("Application");
        setBounds(200,200, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        messageList = new JList<>();
        messageListModel = new DefaultListModel<>();
        messageCellRenderer = new TextMessageCellRenderer();
        messageList.setModel(messageListModel);
        messageList.setCellRenderer(messageCellRenderer);

        scroll = new JScrollPane(messageList,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);

        sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new BorderLayout());

        sendButton = new JButton("Отправить");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = messageField.getText();
                String userTo = null;
                String userToText = null;
                //String userTo = userToField.getText();
                if (text != null && !text.trim().isEmpty()) {
                    if (text.startsWith("/w")) {
                        String [] textParts = text.split(" ");
                        userTo = textParts[1];
                        userToText = textParts[2];
                    }
                    TextMessage msg = new TextMessage(network.getLogin(), userTo, userToText);
                    messageListModel.add(messageListModel.size(), msg);
                    messageField.setText(null);
                    //userToField.setText(null);
                    network.sendTextMessage(msg);
                }
            }
        });
        sendMessagePanel.add(sendButton, BorderLayout.EAST);

        messageField = new JTextField();
        sendMessagePanel.add(messageField, BorderLayout.CENTER);

//        userToField = new JTextField();
//        sendMessagePanel.add(userToField, BorderLayout.WEST);

        add(sendMessagePanel, BorderLayout.SOUTH);
        setVisible(true);

        this.network = new Network("localhost", 7777, this);

        LoginDialog loginDialog = new LoginDialog(this, network);
        loginDialog.setVisible(true);

        if (!loginDialog.isConnected()) {
            System.exit(0);
        }
    }

    @Override
    public void submitMessage(TextMessage message) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                messageListModel.add(messageListModel.size(), message);
                messageList.ensureIndexIsVisible(messageListModel.size() - 1);
            }
        });
    }
}
