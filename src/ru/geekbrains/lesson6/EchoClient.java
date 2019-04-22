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

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread thr1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Ниже можете вводить свои сообщения");
                    while (scanner.hasNextLine()) {
                        //System.out.println("Введите сообщение > ");
                        String line = scanner.nextLine();
                        try {
                            out.writeUTF(line);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            thr1.start();

            Thread thr2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println("Сообщение сервера > " + in.readUTF());
                        } catch (IOException ex) {
                            ex.printStackTrace();
                            break;
                        }
                    }
                }
            });
            thr2.start();

            thr1.join();
            thr2.join();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
