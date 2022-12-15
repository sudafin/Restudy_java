package com.day7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Properties_ {
    public static void main(String[] args) throws IOException{
        Properties_ properties = new Properties_();
        properties.properties();
    }
    public void properties() throws IOException {
        Properties properties = new Properties();
        properties.setProperty("user","john");//设定key 和 值 ，之间用等号相连
        properties.setProperty("age","18");
        properties.store(new FileWriter("src\\com\\day7\\source\\my.properties"),null);//后一个是注释
        System.out.println("保存配置成功");
        String user = properties.getProperty("user");
        String age = properties.getProperty("age");
        System.out.println(user + " "+age);
    }
}
