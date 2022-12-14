package com.day4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class test2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.188.55", 8088);
        System.out.println("客户端启动成功");
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader out = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        while (true){
            String str = out.readLine();
            if("".equals(str)){
                break;
            }
            pw.println(str);
            pw.flush();
            System.out.println("客户端："+str);
            System.out.println("服务端："+in.readLine());
        }
        pw.close();
        in.close();
        out.close();
    }
}
