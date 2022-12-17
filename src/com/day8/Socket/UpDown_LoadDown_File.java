package com.day8.Socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class UpDown_LoadDown_File {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),8080);
        System.out.println("等待服务端");
//        SendText sendText = new SendText(socket);
        SendVideo sendVideo = new SendVideo(socket);
    }
}
class SendText{
    public SendText(Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();//发送文件
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        String s = ReaderFile();
        bufferedWriter.write(s);
        bufferedWriter.flush();
        bufferedWriter.newLine();
        socket.close();
        System.out.println("发送成功");
    }
    public void WriteFile() throws IOException{
        String pathName = "src\\com\\day8\\source\\textClient.text";
        FileWriter fileWriter = new FileWriter(pathName);
        fileWriter.write("你好，这是客户端写的文件\n" +
                "这是一个很好的文件");
        fileWriter.close();
    }
    public String ReaderFile() throws IOException{
        String pathName = "src\\com\\day8\\source\\textClient.text";
        FileReader fileReader = new FileReader(pathName);
        char[] chars = new char[1024];
        int len = 0;
        String name = null;
        while ((len = fileReader.read(chars))!= -1){
            name = new String(chars,0,len);
        }
        fileReader.close();
        return name;
    }
}
class SendVideo{
    public SendVideo(Socket socket) throws IOException{
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(ReaderVideo());
        bufferedOutputStream.flush();
        bufferedOutputStream.close();
        socket.close();
        System.out.println("发送视频成功"+ReaderVideo().length);
    }
    public byte[] ReaderVideo() throws IOException{
        String pathName = "src\\com\\day8\\source\\ClientTest.mp4";
        FileInputStream fileInputStream = new FileInputStream(pathName);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        byte[] bytes;
        bytes = bufferedInputStream.readAllBytes();
        bufferedInputStream.close();
        fileInputStream.close();
        return bytes;
    }
}