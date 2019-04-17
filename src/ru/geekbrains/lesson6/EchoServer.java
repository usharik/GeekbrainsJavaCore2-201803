package ru.geekbrains.lesson6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {


    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(7777);
             Scanner scanner = new Scanner(System.in)) {
            System.out.println("Сервер ожидает подключения!");
            Socket socket = serverSocket.accept();
            System.out.println("Кто-то подключился: " + socket.getInetAddress());

            Communicator communicator = new Communicator(scanner,socket);
            communicator.comm();

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }
}
