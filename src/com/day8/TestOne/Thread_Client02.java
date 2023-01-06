package com.day8.TestOne;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Thread_Client02 {
    static Socket socket;
    public static void main(String[] args) throws IOException, InterruptedException {
        Communicate01();
    }
    public static void Communicate01() throws IOException, InterruptedException {
        System.out.println("开启客户端02");
        System.out.println("开始输入，0结束聊天");
        Log_In logIn = new Log_In();
        logIn.setSocket(socket);
        new Thread(logIn).start();
    }
}