package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandler {

    private final Socket socket;

    private Thread sendThread;
    private Thread receiveThread;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    public void start() {

        sendThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try (Scanner sc = new Scanner(System.in);
                     DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())) {
                    do {
                        System.out.print("Введите сообщение > ");
                        String msg = sc.nextLine();
                        outputStream.writeUTF(msg);
                    } while (true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        receiveThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try (DataInputStream inputStream = new DataInputStream(socket.getInputStream())) {
                    while (true) {
                        System.out.printf("%nНовое сообщение > %s%n", inputStream.readUTF());
                        System.out.print("Введите сообщение > ");
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        sendThread.start();
        receiveThread.start();
    }

    public void join() {
        try {
            sendThread.join();
            receiveThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
