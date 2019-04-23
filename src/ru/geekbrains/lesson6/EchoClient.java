package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws InterruptedException {

        try (Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket("localhost", 7777)) {

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in = new DataInputStream(socket.getInputStream());

            System.out.print("Введите сообщение > ");

            Thread thrSend = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (scanner.hasNextLine()) {
                        System.out.print("Введите сообщение > ");
                        String line = scanner.nextLine();
                        try {
                            out.writeUTF(line);
                        } catch (IOException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                }
            });
            Thread thrGet = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println("Новое сообщение > " + in.readUTF());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            break;
                        }
                    }
                }
            });
            thrSend.start();
            thrGet.start();
            
            thrSend.join();
            thrGet.join();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
