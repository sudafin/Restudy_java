package com.day8.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Communicate02 {
    public static void main(String[] args) throws IOException {
        Socket socket02 = new Socket(InetAddress.getLocalHost(),8080);
        SendServerMessage02 sendServerMessage = new SendServerMessage02(socket02);
        Scanner scanner = new Scanner(System.in);
        boolean Start_Stop = true;
        String message = "输入1开始聊天，输入0关闭聊天";
        System.out.println(message);
        while (Start_Stop){
            if(!message.equals("发送")){
                sendServerMessage.setStart_Stop_bool(true);
                sendServerMessage.start();
                System.out.println("好了");
                message = sendServerMessage.getMessage();
            }
            else {
                Start_Stop = false;
            }
        }
        socket02.close();
    }
}
class SendServerMessage02 extends Thread{
    public static boolean Start_Stop_bool;
    private final Socket socket02;

    private String message;
    public void setStart_Stop_bool(boolean start_Stop_bool) {
        Start_Stop_bool = start_Stop_bool;
    }

    public SendServerMessage02(Socket socket02){
        this.socket02 = socket02;
    }

    public String getMessage() {
        return message;
    }

    public void SendServerInfo() throws IOException {
        message = "开始输入";
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            if(!message.equals("发送")) {
                message = scanner.next();
                socket02.getOutputStream().write(message.getBytes());
            }
            else {
                setStart_Stop_bool(false);
                flag = false;
                socket02.shutdownOutput();
            }
        }

    }
    public void Receive() throws IOException{
        InputStream inputStream = socket02.getInputStream();
        int read ;
        byte[]bytes=new byte[1024];
        while ((read = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,read));
        }
    }
    @Override
    public void run(){
        System.out.println(SendServerMessage02.Start_Stop_bool);
        while (Start_Stop_bool){
            try {
                System.out.println("进去了");
                SendServerInfo();
                System.out.println("出来了");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Receive();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
