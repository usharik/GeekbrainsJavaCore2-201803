package ru.geekbrains.lesson6;


import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientHomeWork6 {

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 6666)){
            SocketHandlerHomeWork6 socketHandler = new SocketHandlerHomeWork6(socket);
            socketHandler.start();
            socketHandler.join();
          } catch (IOException e) {
            e.printStackTrace();
        }
    }

}