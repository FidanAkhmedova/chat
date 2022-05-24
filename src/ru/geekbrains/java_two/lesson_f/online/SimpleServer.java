package ru.geekbrains.java_two.lesson_f.online;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189);
             Socket client = server.accept()) {
//            Socket client = server.accept();
            System.out.println("client connected");
            DataInputStream in = new DataInputStream(client.getInputStream());
            DataOutputStream out = new DataOutputStream(client.getOutputStream());
            while (true) {
                String msg = in.readUTF();
                out.writeUTF("echo: " + msg);
            }
//            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
