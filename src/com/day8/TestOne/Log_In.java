package com.day8.TestOne;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

public class Log_In implements Runnable{


    private Socket socket;
    private boolean IsExist;
    private boolean IsTrue;
    String ClientUser,ClientId,ClientPassword;
    public boolean getIsTrue() {
        return IsTrue;
    }
    public void setSocket(Socket socket){
        this.socket = socket;
    }
    public void InputData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名");
        ClientUser = scanner.next();
        System.out.println("输入id");
        ClientId = scanner.next();
        System.out.println("输入password");
        ClientPassword = scanner.next();
    }
    public synchronized void Function() throws IOException, InterruptedException {
        Log_In logIn = new Log_In();
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        InputData();
        Is_log();
        while (loop) {
            if (!IsExist) {
                System.out.println("id不存在，你没有注册");
                String choice;
                System.out.println("你是否需要注册,输入y or f");
                choice = scanner.next();
                if (choice.equals("y")) {
                    Sign_Up signUp = new Sign_Up();
                    Thread sign_t = new Thread(signUp);
                    sign_t.start();
                    sign_t.join();
                    System.out.println("注册成功");
                    Is_log();
                }else {
                    System.out.println("退出聊天");
                    break;
                }
            } else if (!IsTrue) {
                System.out.println("密码错误重新输入");
                ClientPassword = scanner.next();
                Is_log();
            } else{
                loop = false;
            }
        }
        if(!loop) {
            System.out.println("登录成功");
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            Send_Server sendServer = new Send_Server(socket,ClientUser);
            new Thread(sendServer).start();
        }
    }
    public void Is_log() throws IOException {
          Properties properties = new Properties();
          properties.load(new FileReader("src\\com\\day8\\source\\my.properties"));
          String SaveId = properties.getProperty(ClientUser+"id");
          String SavePassword = properties.getProperty(ClientUser+"password");
          if(SaveId==null){
              IsExist = false;
          }else if(SaveId.equals(ClientId)&&!SavePassword.equals(ClientPassword)){
              IsExist = true;
              IsTrue =false;
          } else if(SavePassword.equals(ClientPassword)){
              IsExist = true;
              IsTrue = true;
          }
     }

    @Override
    public void run() {
        try {
            Function();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
