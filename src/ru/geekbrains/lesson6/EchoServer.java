package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) throws InterruptedException {
        try (Scanner scanner = new Scanner(System.in);
             ServerSocket serverSocket = new ServerSocket(7777)) {
            while (true) {
                System.out.println("Сервер ожидает подключения!");
                Socket socket = serverSocket.accept();

                System.out.println("Кто-то подключился: " + socket.getInetAddress());

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
                                System.out.println("Сообщение клиента > " + in.readUTF());
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
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
