package com.day4;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Time;

public class test {
    public static void main(String[] args)throws IOException {
        ServerSocket ss = new ServerSocket(8088);
        System.out.println("服务器建立成功");
        Socket socket = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader out = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        while (true){
            System.out.println("客户端说:"+in.readLine());
            String str = out.readLine();
            if(str == null)
            {
                break;
            }
            pw.println(str);
            //通过socket对象将字符串推送到服务器
            pw.flush();
            System.out.println("服务端说："+str);
        }
        in.close();
        out.close();
        pw.close();
        socket.close();
        ss.close();
    }
}