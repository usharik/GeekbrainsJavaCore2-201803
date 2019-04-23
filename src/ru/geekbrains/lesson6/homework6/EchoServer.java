package ru.geekbrains.lesson6.homework6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in);
             ServerSocket serverSocket = new ServerSocket(7777)) {
            while (true) {
                System.out.println("Сервер ожидает подключения!");
                Socket socket = serverSocket.accept();

                System.out.println("Кто-то подключился: " + socket.getInetAddress());

                Transmitter transmitter = new Transmitter(scanner, socket);
                transmitter.msgTrans();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
