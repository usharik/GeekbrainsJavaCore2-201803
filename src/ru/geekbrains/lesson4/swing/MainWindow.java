package ru.geekbrains.lesson4.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JTextArea messagesArea = new JTextArea();
    private JTextField messageField = new JTextField();

    public MainWindow() {
        setTitle("Chat");
        setBounds(200,200, 500, 500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        messagesArea.setLineWrap(true);
        messagesArea.setWrapStyleWord(true);
        messagesArea.setEditable(false);

        JScrollPane scroll = new JScrollPane(messagesArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);

        JPanel sendMessagePanel = new JPanel();
        sendMessagePanel.setLayout(new BorderLayout());
        sendMessagePanel.add(messageField, BorderLayout.CENTER);
        add(sendMessagePanel, BorderLayout.SOUTH);

        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printMsg(messageField.getText());
            }
        });

        JButton sendButton = new JButton("Отправить");
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printMsg(messageField.getText());
            }
        });

        sendMessagePanel.add(sendButton, BorderLayout.EAST);

        setVisible(true);
    }


    private void printMsg(String msg){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                if(msg.equals("")) return;
                messagesArea.append(msg + "\n");
                messagesArea.setCaretPosition(messagesArea.getDocument().getLength());
                messageField.setText("");
            }
        });
    }

}