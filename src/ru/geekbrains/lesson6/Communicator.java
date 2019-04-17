package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Communicator {
    Scanner scanner;
    Socket socket;

    public Communicator(Scanner scanner, Socket socket) {
        this.scanner = scanner;
        this.socket = socket;
    }

    public void comm() throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());

        Thread threadListener = new Thread(new Listener(in));
        threadListener.start();


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
