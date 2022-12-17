package com.day8.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket_Reade_Writer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("等待客户端输入");
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        OutputStream outputStream = accept.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        bufferedWriter.write("你好，客户端");
        bufferedWriter.newLine();//换行，告诉客户端到处结束，跟字节流不一样，是用字符流换出来的;
        bufferedWriter.flush();//写入数据，不然不能写
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedWriter.close();
        bufferedReader.close();
        accept.close();
    }
}
