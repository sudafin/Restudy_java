package com.day8.Socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Dictionary;

public class UpDown_LoadDown_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(999);
        System.out.println("等待客户端");
        Socket accept = serverSocket.accept();
//        SaveText = new SaveText(accept);
//        SaveVideo saveVideo = new SaveVideo(accept);
        SendVideo sendVideo = new SendVideo(accept);
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
class SendVideo{
    public SendVideo(Socket socket) throws IOException{
        OutputStream WordoutputStream = socket.getOutputStream();
        InputStream inputStream = socket.getInputStream();
        StringBuilder pathName = new StringBuilder("src\\com\\day8\\source\\");
        PrintStream printStream = new PrintStream(WordoutputStream);
        File file = new File(pathName.toString());
        String[] list = file.list();
        assert list != null;
        for (String index :
                list) {
            String[] split = index.split("\\.");
            printStream.println(split[0]);
        }
        printStream.flush();
        byte[] bytes = new byte[2048];
        int len;
        String ChildPathName ="";
        StringBuilder stringBuilder = null;
        while ((len = inputStream.read(bytes))!= -1){
            ChildPathName = new String(bytes,0,len);
            stringBuilder = new StringBuilder(ChildPathName);
            stringBuilder.append(".mp4");
        }
        for (String s : list) {
            assert stringBuilder != null;
            if (stringBuilder.toString().equals(s)) {
                pathName.append(stringBuilder);
                break;
            }
        }
        FileInputStream fileInputStream = new FileInputStream(pathName.toString());
        int read = 0;
        byte []File_byte = new byte[2048];
        while ((read = fileInputStream.read(File_byte))!=-1){
            WordoutputStream.write(File_byte,0,read);
        }
        fileInputStream.close();
        socket.close();
    }
}