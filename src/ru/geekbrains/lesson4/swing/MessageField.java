package ru.geekbrains.lesson4.swing;

import javax.swing.*;

public class MessageField extends JTextField {

    String yourMessage;

    MessageField(){
        getText();
    }

    MessageField(String yourMessage){
        this.yourMessage = yourMessage;
    }

    @Override
    public String getText() {
        return super.getText();
    }
}