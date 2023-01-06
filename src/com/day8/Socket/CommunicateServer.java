package com.day8.Socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CommunicateServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("等待 成员01 和 成员02 的连接");
        Socket accept01 = serverSocket.accept();
        Socket accept02 = serverSocket.accept();
        System.out.println("成员01 和 成员02 成功地连接");
        Receive_Send_ClientInfo receiveSendClientInfo01 = new Receive_Send_ClientInfo(accept01,accept02);
        Receive_Send_ClientInfo receiveSendClientInfo02 = new Receive_Send_ClientInfo(accept02,accept01);
        receiveSendClientInfo01.start();
        receiveSendClientInfo02.start();
        serverSocket.close();
    }
}
class Receive_Send_ClientInfo extends Thread{

    public boolean ret = true;
    private String message;
    private boolean Control = true;
    private final Socket socket01,socket02;
    public Receive_Send_ClientInfo(Socket socket01,Socket socket02){
        this.socket01 = socket01;
        this.socket02 = socket02;
    }
    public void Receive(){
        byte [] bytes = new byte[1024];
        InputStream inputStream;
        int read;
        try {
            inputStream = socket01.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            while ((read = inputStream.read(bytes))!=-1){
                message = new String(bytes,0,read);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void Send() {
        OutputStream outputStream ;
        try {
            outputStream = socket02.getOutputStream();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            if(message.equals("发送")){
                socket02.shutdownOutput();
                Control = false;
            }
            else {
                outputStream.write(message.getBytes());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void run() {
      while (Control){
          try {
              Receive();
              Send();
          } catch (Exception e) {
              throw new RuntimeException(e);
          }
      }
    }

}