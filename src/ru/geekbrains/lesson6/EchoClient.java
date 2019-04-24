package ru.geekbrains.lesson6;


import java.io.IOException;
import java.net.Socket;


public class EchoClient {

    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 7777)) {
            Messenger messenger = new Messenger(socket);
            messenger.start();
            messenger.join();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
