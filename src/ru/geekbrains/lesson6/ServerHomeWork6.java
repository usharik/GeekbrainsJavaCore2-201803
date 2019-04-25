package ru.geekbrains.lesson6;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerHomeWork6 {

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(6666); ){
            while(true){
                System.out.println("Сервер ожидает подключения.");
                Socket socket = serverSocket.accept();
                System.out.println("Кто-то подключился: " + socket.getInetAddress());
                SocketHandlerHomeWork6 socketHandler = new SocketHandlerHomeWork6(socket);
                socketHandler.start();
                }
            }
         catch (IOException e){
            e.printStackTrace();
        }
    }
}
