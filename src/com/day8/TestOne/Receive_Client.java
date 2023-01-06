package com.day8.TestOne;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Receive_Client implements Runnable{
    public String message;
    private Socket socket;
    public Receive_Client(Socket socket){
      this.socket = socket;
    }
    public void Receive() throws IOException {
        InputStream inputStream = socket.getInputStream();
        int len = 0;
        byte []bytes = new byte[1024];
        while ((len = inputStream.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }
    }

    @Override
    public void run() {
        try {
            Receive();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
