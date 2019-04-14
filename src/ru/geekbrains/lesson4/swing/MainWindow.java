package ru.geekbrains.lesson4.swing;


import javafx.beans.value.ChangeListener;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {


    JTextArea messagesArea;
    JTextField messageField;


    public MainWindow() {
        setTitle("Чак-Чак");
        setBounds(200,200, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());


        messagesArea = new JTextArea();
        messagesArea.setLineWrap(true);
        messagesArea.setWrapStyleWord(true);
        messagesArea.setEditable(false);


        scroll = new JScrollPane(messagesList,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);

        sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new BorderLayout());

        JButton sendButton = new JButton("Отправить");

        sendMessagePanel.add(sendButton, BorderLayout.EAST);
        messageField = new MessageField();

        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    sendMessage(messageField.getText());
            }
        });

        sendMessagePanel.add(messageField, BorderLayout.CENTER);

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(messageField.getText());
            }
        });

        add(sendMessagePanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void sendMessage(String yourMessage) {
        messagesArea.append("Вы: " + yourMessage);
        messageField.setText("");
        messagesArea.append("\n");
        messageField.grabFocus();
    }
}
