package ru.geekbrains.lesson6.homework6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Transmitter {

    Scanner scanner;
    Socket socket;

    public Transmitter(Scanner scanner, Socket socket) {
        this.scanner = scanner;
        this.socket = socket;
    }

    public void msgTrans() throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        Thread thread = new Thread(new Listener(in));
        thread.start();


        System.out.print("Введите сообщение > ");
        while (scanner.hasNextLine()) {
            System.out.print("Введите сообщение > ");
            String line = scanner.nextLine();
            try {
                out.writeUTF(line);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}

