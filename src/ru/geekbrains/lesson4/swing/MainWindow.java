package ru.geekbrains.lesson4.swing;

import ru.geekbrains.lesson4.MessageReciever;
import ru.geekbrains.lesson4.Network;
import ru.geekbrains.lesson4.TextMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;


public class MainWindow extends JFrame implements MessageReciever {

    private final JList<TextMessage> messageList;

    private final DefaultListModel<TextMessage> messageListModel;

    private final TextMessageCellRenderer messageCellRenderer;

    private final JScrollPane scroll;

    private final JPanel sendMessagePanel;

    private final JButton sendButton;

    private final JTextField messageField;

   // private final JTextField userField;

    private final JList<String> userList;

    private final DefaultListModel<String> userListModel;

    private final Network network;


    public MainWindow() {
        setTitle("Сетевой чат.");
        setBounds(200, 200, 500, 500);
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
                sendMsg();
            }
        });
        sendMessagePanel.add(sendButton, BorderLayout.EAST);

        messageField = new JTextField("Выберите пользователя для отправки сообщения...");
        messageField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (messageField.getText().equals("Выберите пользователя для отправки сообщения..."))
                    messageField.setText(null);
            }
        });

        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMsg();
            }
        });
        //userField = new JTextField("", 7);
        //sendMessagePanel.add(userField, BorderLayout.WEST);
        sendMessagePanel.add(messageField, BorderLayout.CENTER);
        add(sendMessagePanel, BorderLayout.SOUTH);
        userList = new JList<>();
        userListModel = new DefaultListModel<>();
        userList.setModel(userListModel);
        userList.setPreferredSize(new Dimension(100, 0));
        add(userList, BorderLayout.WEST);

        setVisible(true);

        this.network = new Network("localhost", 7777, this);

        LoginDialog loginDialog = new LoginDialog(this, network);
        loginDialog.setVisible(true);

        if (!loginDialog.isConnected()) {
            System.exit(0);
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if (network != null) {
                    network.close();
                }
                super.windowClosing(e);
            }
        });

        setTitle("Сетевой чат. Пользователь " + network.getLogin());

    }

    private void sendMsg(){
        if(messageField.getText().equals("Выберите пользователя для отправки сообщения...")){
            messageField.setText(null);
        }

        String text = messageField.getText();
        String userTo = userList.getSelectedValue();

        if (text.isEmpty() || userTo == null || text.trim().isEmpty()) {
            JOptionPane.showMessageDialog(MainWindow.this,
                    "Выберите получателя либо введите сообщение",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
            return;
        } else {
            TextMessage msg = new TextMessage(network.getLogin(), userTo, text);
            messageListModel.add(messageListModel.size(), msg);
            messageField.setText(null);
            network.sendTextMessage(msg);
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

    @Override
    public void userConnected(String login) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int ix = userListModel.indexOf(login);
                if (ix == -1) {
                    userListModel.add(userListModel.size(), login);
                }
            }
        });
    }

    @Override
    public void userDisconnected(String login) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int ix = userListModel.indexOf(login);
                if (ix >= 0) {
                    userListModel.remove(ix);
                }
            }
        });
    }

    @Override
    public void usersOnline (List<String> users) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                userListModel.clear();
                for (String user: users){
                    if (!user.equals(network.getLogin())){
                        userListModel.addElement(user);
                    }
                }
            }
        });
    }

}
