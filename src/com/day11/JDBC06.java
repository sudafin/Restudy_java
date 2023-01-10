package com.day11;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBC06 {
    public static void main(String[] args) throws Exception {
        Connection connection = JDBCUtils.getConnection();
        String sql = "insert into test3_table values (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        for (int i = 0; i < 5000; i++) {
            preparedStatement.setInt(1,i);
            preparedStatement.setString(2,"jack"+i);
            preparedStatement.addBatch();
            if((i+1)%1000 == 0){
            preparedStatement.executeBatch();
            preparedStatement.clearBatch();
            }
        }
        JDBCUtils.Close(null,preparedStatement,connection);
    }
}
