package com.day8.TestOne;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Send_Server implements Runnable{
    private Socket socket;
    private String name;
    public Send_Server(Socket socket,String name){
        this.socket = socket;
        this.name = name;
    }
    public void Send() throws IOException {
        OutputStream outputStream = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        String s ="";
        while (!s.equals("0")) {
            s = scanner.next();
            if(!s.equals("0")){
                outputStream.write((name+":\t"+s).getBytes());
            }else {
                outputStream.write((name + "退出聊天").getBytes());
                outputStream.close();//记得关闭该线程的流
            }
        }
    }
    @Override
    public void run() {
        try {
            Send();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
