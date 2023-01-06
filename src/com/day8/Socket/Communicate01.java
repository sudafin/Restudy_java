package com.day8.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Communicate01 {
    public static void main(String[] args) throws IOException {
        Socket socket01 = new Socket(InetAddress.getLocalHost(),8080);
        SendServerMessage sendServerMessage = new SendServerMessage(socket01);
        Scanner scanner = new Scanner(System.in);
        boolean Start_Stop = true;
        int ret;
        while (Start_Stop){
            System.out.println("输入1开始聊天，输入0关闭聊天");
            ret = scanner.nextInt();
            if(ret == 1){
                sendServerMessage.start();
            }
            else if(ret == 0){
                Start_Stop = false;
            }
        }
        socket01.close();
    }
}
class SendServerMessage extends Thread{
    private boolean Start_Stop_bool = true;
    private final Socket socket01;

    public boolean isStart_Stop_bool() {
        return Start_Stop_bool;
    }

    public void setStart_Stop_bool(boolean start_Stop_bool) {
        Start_Stop_bool = start_Stop_bool;
    }

    public SendServerMessage(Socket socket01){
        this.socket01 = socket01;
    }
    public void SendServerInfo() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s = "开始输入";
        boolean flag = true;
        while (flag) {
            if(!s.equals("发送")) {
                s = scanner.next();
                socket01.getOutputStream().write(s.getBytes());
            }
            else {
                setStart_Stop_bool(false);
                flag = false;
                socket01.shutdownOutput();
            }
        }

    }
    public void Receive() throws IOException{
        InputStream inputStream = socket01.getInputStream();
        int read ;
        byte[]bytes=new byte[1024];
        while ((read = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,read));
        }
    }
    @Override
    public void run(){
        System.out.println(SendServerMessage.currentThread().getName());
        while (Start_Stop_bool){
            try {
                SendServerInfo();
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
    public Socket getSocket01() {
        return socket01;
    }
}
