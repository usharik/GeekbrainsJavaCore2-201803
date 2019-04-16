package ru.geekbrains.lesson4;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.*;

public class ChatWindow extends JFrame{
    public ChatWindow() {
        setTitle("Чат");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 400);
        setVisible(true);
        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(new BorderLayout());
        JTextArea textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Dialog", Font.PLAIN, 15));
        JScrollPane scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scroll, BorderLayout.CENTER);

        JPanel message = new JPanel();
        message.setLayout(new BorderLayout());
        JButton button = new JButton("отправить");
        message.add(button, BorderLayout.EAST);
        JTextField messageField = new JTextField();
        message.add(messageField, BorderLayout.CENTER);
        add(message, BorderLayout.SOUTH);
        String userMessage = messageField.getText();


        setVisible(true);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Ваше сообщение: " + messageField.getText() + "\n");
               // JOptionPane.showMessageDialog(ChatWindow.this, messageField.getText(), "Заголовок", JOptionPane.INFORMATION_MESSAGE);

            }
        });
        messageField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    textArea.append("Ваше сообщение: " + messageField.getText() +"\n");
                }
            }
        });


    }

    public static void main(String[] args) {
        new ChatWindow();


    }
}
