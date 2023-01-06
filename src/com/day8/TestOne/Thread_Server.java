package com.day8.TestOne;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Thread_Server {
    static ServerSocket serverSocket;
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("服务端接入");
        serverSocket = new ServerSocket(9999);
        Socket accept01 = serverSocket.accept();
        System.out.println("01连接成功");
        Socket accept02 = serverSocket.accept();
        System.out.println("02连接成功");
        System.out.println("客户端全部已接入");
        Receive_Client receiveClient = new Receive_Client(accept01);
        Receive_Client receiveClient1 = new Receive_Client(accept02);
        Thread thread = new Thread(receiveClient1);
        Thread thread1 = new Thread(receiveClient);
        thread.start();
        thread1.start();
        serverSocket.close();
    }
}