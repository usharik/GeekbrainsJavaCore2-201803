


/* pulrequest link: https://github.com/usharik/GeekbrainsJavaCore2-201803/pull/49 */




package ru.geekbrains.lesson6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SocketHandlerHomeWork6 {

    private final Socket socket;
    private Thread sendThread;
    private Thread recieveThread;

    public SocketHandlerHomeWork6(Socket socket) {
        this.socket = socket;
    }

    public void start (){
        sendThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try(Scanner scanner = new Scanner(System.in); DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream())){
                    do {
                        System.out.print("Введите сообщение: ");
                        String msg = scanner.nextLine();
                        outputStream.writeUTF(msg);

                    } while (true);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

        recieveThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try(DataInputStream inputStream = new DataInputStream(socket.getInputStream())){
                    while (true) {
                        System.out.println("Получено сообщение: " + inputStream.readUTF());
                    }

                } catch (IOException e){
                    e.printStackTrace();
                }

            }
        });

        sendThread.start();
        recieveThread.start();



    }

    public void join(){
        try{
            sendThread.join();
            recieveThread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
