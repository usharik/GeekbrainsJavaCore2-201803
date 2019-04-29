package ru.geekbrains.lesson6;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    public static void main(String[] args) throws InterruptedException {

        try (Scanner scanner = new Scanner(System.in);
            Socket socket = new Socket("localhost", 7777)) {
            Sender sender = new Sender(socket);
            sender.start();
            sender.join();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
