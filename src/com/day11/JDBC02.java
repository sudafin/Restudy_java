package com.day11;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBC02 {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\day11\\source\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        String sql = "select * from test1_table";
        ResultSet resultSet = statement.executeQuery(sql); //得到指向数据表的表头
        while (resultSet.next()){
            //获取行的列数据
            int class_id = resultSet.getInt(1); //第一列是 class_id
            String name = resultSet.getString(2); // name
            System.out.println(class_id +"\t"+ name);
        }
        resultSet.close();
        statement.close();
        connection.close();

    }
}
