package com.day8.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class UpDown_LoadDown_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("等待客户端");
        Socket accept = serverSocket.accept();
//        SaveText = new SaveText(accept);
        SaveVideo saveVideo = new SaveVideo(accept);
        serverSocket.close();
    }
}
class SaveText{
    public SaveText(Socket accept) throws IOException{
        String pathName = "src\\com\\day8\\source\\AcceptTextClient.text";
        InputStream inputStream = accept.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        FileWriter fileWriter = new FileWriter(pathName);
        String s = "";
        while ((s = bufferedReader.readLine())!=null){
            fileWriter.write(s);
            fileWriter.write('\n');//一行打完换行
        }
        System.out.println("接受成功");
        fileWriter.close();
        bufferedReader.close();
        accept.close();
    }
}
class SaveVideo{
    public SaveVideo(Socket socket) throws IOException{
        String pathName = "src\\com\\day8\\source\\SaveClientTest.mp4";
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(pathName);
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes))!= -1){
            fileOutputStream.write(bytes,0,len);
        }
        socket.shutdownInput();
        fileOutputStream.close();
        socket.close();
        System.out.println("接受视频成功"+bytes.length);
    }
}