package com.day11;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class JDBC03 {
    public static void main(String[] args) throws Exception{
        Scanner sc= new Scanner(System.in);
        int class_id = sc.nextInt();
        String name = sc.next();
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\day11\\source\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);

        //查看
        String sql = "select class_id,name from test1_table where class_id = ? and name = ? ";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setInt(1,class_id);
//        preparedStatement.setString(2,name);
//        ResultSet resultSet = preparedStatement1.executeQuery(); //不用在写sql进去
        //        if(resultSet.next()){
//            System.out.println("成功");
//        }
//        else System.out.println("失败");

        //dml
        String sql2 = "insert into test1_table values(?,?)"; //增加
        String sql3 = "delete from test1_table where class_id =?"; //删除
        String sql4 = "update test1_table set name = ? where class_id = ?"; //更新
        PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
        PreparedStatement preparedStatement3 = connection.prepareStatement(sql3);
        PreparedStatement preparedStatement4 = connection.prepareStatement(sql4);
        preparedStatement4.setString(1,name);
        preparedStatement4.setInt(2,class_id);
        int i = preparedStatement4.executeUpdate();
        System.out.println(i > 0?"success":"fault" );
//        resultSet.close();
//        preparedStatement1.close();
        connection.close();
    }
}
