package com.day8.Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientSocket_Reade_Writer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8080);
        System.out.println("等待服务端接受");
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        bufferedWriter.write("你好，服务端");
        bufferedWriter.newLine();//重点：换行，告诉服务端到处结束，跟字节流不一样，是用字符流换出来的;
        bufferedWriter.flush();//重点：写入数据，不然不能写
        String s = bufferedReader.readLine();
        System.out.println(s);
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
    }
}
