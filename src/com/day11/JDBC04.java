package com.day11;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBC04 {
    public static void main(String[] args) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql0 = "insert into test1_table values (5,'java')";
        String sql = "select * from test2.test1_table";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        PreparedStatement preparedStatement1 = connection.prepareStatement(sql0);
        int i = preparedStatement1.executeUpdate();
        ResultSet resultSet = preparedStatement.executeQuery();
        if(i > 0){
            System.out.println("成功插入");
        }
        while (resultSet.next()){
            System.out.println(resultSet.getInt("class_id") +"\t" + resultSet.getString("name"));
        }
    }
}
