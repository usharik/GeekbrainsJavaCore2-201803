package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class NWlib {
    Scanner scanner;
    Socket socket;

    public NWlib(Scanner scanner, Socket socket) {
        this.scanner = scanner;
        this.socket = socket;
    }

    public void net() throws IOException {
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

class Listener implements Runnable {

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