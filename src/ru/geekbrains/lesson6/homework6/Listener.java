package ru.geekbrains.lesson6.homework6;

import java.io.DataInputStream;
import java.io.IOException;

public class Listener implements Runnable{

    DataInputStream in;

    public Listener(DataInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("\nНовое сообщение > " + in.readUTF());
                System.out.print("Введите сообщение > ");
            } catch (IOException ex) {
                ex.printStackTrace();
                break;
            }
        }
    }
}