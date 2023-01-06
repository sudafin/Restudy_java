package com.day8.Socket;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class UpDown_LoadDown_File {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(),999);
        System.out.println("等待服务端");
//        SendText UpText = new SendText(socket);
//        UpVideo UpVideo = new UpVideo(socket);
        LoadVideo loadVideo = new LoadVideo(socket);
    }
}
class UpText{
    public UpText(@NotNull Socket socket) throws IOException {
        OutputStream outputStream = socket.getOutputStream();//发送文件的操作
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);//字节流无法处理文字，要转化成字符流
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);//用字符缓冲流
        String s = ReaderFile();//接受文字的数据用String接受
        bufferedWriter.write(s);//输出文字
        bufferedWriter.flush();//输出完毕
        bufferedWriter.newLine();//发送完毕
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
class UpVideo{
    public UpVideo(Socket socket) throws IOException{
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);//用字节缓冲流快一点
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
class LoadVideo{
    public LoadVideo(Socket socket) throws IOException{
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        int len;
        byte[] bytes = new byte[2048];
        while ((len = bufferedInputStream.read(bytes))!= -1){ //因为服务端没有关掉输入流，就会发生堵塞，所以我们直接把代码弄到到里面来解决问题
            System.out.println(new String(bytes,0,len));
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            scanner.close();
            outputStream.write(s.getBytes());
            socket.shutdownOutput();
            FileOutputStream fileOutputStream = new FileOutputStream("src\\com\\day8\\source\\DownLoad.mp4");
            byte[] byte1;
            byte1 = bufferedInputStream.readAllBytes();
            fileOutputStream.write(byte1);
            fileOutputStream.flush();
            fileOutputStream.close();
            socket.close();
        }

    }
}