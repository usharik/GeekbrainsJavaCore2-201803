package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender {

    private final Socket socket;
    private Thread thrGet;
    private Thread thrSend;

    public Sender(Socket socket) {
        this.socket = socket;
    }

    public  void start() {
        thrGet = new Thread(new Runnable() {
            @Override
            public void run() {
                try (DataInputStream in = new DataInputStream(socket.getInputStream())) {
                    while (true) {
                        System.out.printf("\nНовое сообщение > " + in.readUTF());
                        System.out.print("\nВведите сообщение > ");

                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        thrSend = new Thread(new Runnable() {
            @Override
            public void run() {
                try (Scanner scan = new Scanner(System.in);
                     DataOutputStream out = new DataOutputStream(socket.getOutputStream())
                ) {
                    do {
                        System.out.print("Введите сообщение > ");
                        String line = scan.nextLine();
                        out.writeUTF(line);
                    } while (true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thrSend.start();
        thrGet.start();
    }

    public void join(){
        try {
            thrGet.join();
            thrSend.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
