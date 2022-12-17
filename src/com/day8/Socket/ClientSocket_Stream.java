package com.day8.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket_Stream{
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),80);
        System.out.println("客户端运行");
        OutputStream outputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        outputStream.write("hello,Server".getBytes());//发送给服务端
        socket.shutdownOutput();//重点
        int read;
        byte[] bytes = new byte[1024];
        while ((read = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,read));
        }

        socket.close();
        outputStream.close();
    }
}
