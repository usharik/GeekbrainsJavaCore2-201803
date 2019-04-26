package ru.geekbrains.lesson4.swing;

import ru.geekbrains.lesson4.MessageReciever;
import ru.geekbrains.lesson4.Network;
import ru.geekbrains.lesson4.TextMessage;
import ru.geekbrains.lesson7.ChatServer;

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

    private final JButton sendButton;

    private final JTextField messageField;

    private final JTextField toUserField;

    private final Network network;


    public MainWindow() {

        this.network = new Network("localhost", 7777, this);

        setTitle(this.network.getLogin());      //не работает... даже понял почему, но не успеваю решить данную проблему,
                                                //если есть возможность обновить окно после аутетификации
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
                String userTo = toUserField.getText();
                if (text.isEmpty() || userTo.isEmpty() || text.trim().isEmpty()){
                JOptionPane.showMessageDialog(MainWindow.this,
                        "Введите имя адресата либо сообщение",
                        "Пустое поле",
                        JOptionPane.ERROR_MESSAGE);
                return;
                }
                TextMessage msg = new TextMessage(network.getLogin(), userTo, text);
                messageListModel.add(messageListModel.size(), msg);
                messageField.setText(null);
                network.sendTextMessage(msg);
            }
        });

        toUserField = new JTextField();
        toUserField.setPreferredSize(new Dimension(50, 0));
        sendMessagePanel.add(toUserField, BorderLayout.WEST);
        sendMessagePanel.add(sendButton, BorderLayout.EAST);
        messageField = new JTextField();
        sendMessagePanel.add(messageField, BorderLayout.CENTER);

        add(sendMessagePanel, BorderLayout.SOUTH);

        setVisible(true);

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