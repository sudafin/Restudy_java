package com.day11;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;

public class JDBC05 {
    public static void main(String[] args) throws Exception{
        Connection connection = JDBCUtils.getConnection();
        connection.setAutoCommit(false);
        String sql = "update test1_table set class_id = ? + 3 where name = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Savepoint savepoint = connection.setSavepoint();
        preparedStatement.setInt(1,3);
        preparedStatement.setString(2,"C语言");
        int i = preparedStatement.executeUpdate();
        System.out.println(i>0?"success":"false");
        connection.commit();
        ResultSet resultSet = preparedStatement.executeQuery();
        JDBCUtils.Close(resultSet,preparedStatement,connection);
    }
}
