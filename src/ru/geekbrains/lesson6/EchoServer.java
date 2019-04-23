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

                System.out.print("Введите сообщение > ");

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


                    thrSend.start();
                    thrGet.start();

                    thrGet.join();
                    thrSend.join();

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
