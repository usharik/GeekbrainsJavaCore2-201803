package ru.geekbrains.lesson6;

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
                Sender sender = new Sender(socket);

                System.out.println("Кто-то подключился: " + socket.getInetAddress());
                sender.start();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
