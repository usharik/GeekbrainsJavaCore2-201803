package ru.geekbrains.lesson4.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    public MainWindow() {
        setTitle("Application");
        setBounds(200, 200, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JTextArea messagesArea = new JTextArea();
        messagesArea.setLineWrap(true);
        messagesArea.setWrapStyleWord(true);
        messagesArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(messagesArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);

        JPanel sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new BorderLayout());
        JButton sendButton = new JButton("Отправить");
        sendMessagePanel.add(sendButton, BorderLayout.EAST);
        JTextField messageField = new JTextField();
        sendMessagePanel.add(messageField, BorderLayout.CENTER);

        add(sendMessagePanel, BorderLayout.SOUTH);

        Action sendMessage = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagesArea.append(messageField.getText() + '\n');
                messageField.setText("");
            }
        };

        sendButton.addActionListener(sendMessage);
        messageField.addActionListener(sendMessage);

        setVisible(true);
    }
}
