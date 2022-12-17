package com.day8.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket_Stream{
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);//如果没有客户端将会在这堵塞
        System.out.println("等待客户端");
        Socket socket = serverSocket.accept();//客户端发送，服务端接受，服务端可以接受多个客户端的信息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,Client".getBytes());//发送到客户端
        socket.shutdownOutput();//重点：关闭到输出端，让客户端知道输出结束，这三个要一起写
        InputStream inputStream = socket.getInputStream();
        int read = 0;
        byte[] bytes = new byte[1024];
        while ((read = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,read));
        }
        inputStream.close();
        socket.close();
    }
}
