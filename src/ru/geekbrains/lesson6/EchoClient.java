package ru.geekbrains.lesson6;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) throws InterruptedException {

        try (Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket("localhost", 7777)) {

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Thread thr = new Thread(new Runnable() {
                @Override
                public void run() {
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
            });
            thr.start();
            thr.join();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
