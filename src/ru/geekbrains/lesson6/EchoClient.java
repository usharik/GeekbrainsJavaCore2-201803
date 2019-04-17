package ru.geekbrains.lesson6;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in);
             Socket socket = new Socket("localhost", 7777)) {

            Communicator communicator = new Communicator(scanner,socket);
            communicator.comm();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
