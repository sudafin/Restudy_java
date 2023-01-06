package com.day8.TestOne;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Sign_Up implements Runnable{
    public  void properties() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("hello,输入user");
        String user = scanner.next();
        System.out.println("输入id");
        String id = scanner.next();
        System.out.println("输入password");
        String password = scanner.next();
        Properties properties = new Properties();
        properties.load(new FileReader("src\\com\\day8\\source\\my.properties"));
        if(properties.containsKey(user+"id")){
            System.out.println("已经有此ID");
            System.out.println("输入id");
            id = scanner.next();
        }
        properties.setProperty(user+"id", id);
        properties.setProperty(user+"password", password);
        properties.store(new FileWriter("src\\com\\day8\\source\\my.properties",true),null);
    }
    @Override
    public void run() {
        try {
            properties();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}