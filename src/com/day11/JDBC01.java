package com.day11;
import com.mysql.jdbc.Driver; // 引入jdbc包
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBC01 {
    public static void main(String[] args) throws Exception {
    }

    @Test
    public void Connect01() throws SQLException{
        //注册驱动
        Driver driver = new Driver();
        //得到连接 jdbc:mysql://ip/database_name: -- 固定模板
        String url = "jdbc:mysql://localhost:3306/test2";
        //将用户名和密码放在properties对象
        Properties properties = new Properties();
        properties.setProperty("user","root"); // 用户
        properties.setProperty("password","123"); //密码
        Connection connect = driver.connect(url, properties);
        //执行sql
        String sql = "insert into test1_table values(3,'C语言')";
        //statement 用于执行静态SQL语句并返回其生成结果的对象
        Statement statement = connect.createStatement();
        int ret = statement.executeUpdate(sql); //如果是dml(增，删，改)语句，返回的就是影响行数：
        System.out.println(ret>0?"成功":"失败");
        //关闭连接资源
        statement.close();
        connect.close();
    }
    @Test
    public void Connect02() throws Exception{
        //反射加载Driver类，动态加载，更加灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        //得到连接 jdbc:mysql://ip/database_name: -- 固定模板
        String url = "jdbc:mysql://localhost:3306/test2";
        //将用户名和密码放在properties对象
        Properties properties = new Properties();
        properties.setProperty("user","root"); // 用户
        properties.setProperty("password","123"); //密码
        Connection connect = driver.connect(url, properties);
        System.out.println(connect);
    }
    @Test
    public void Connect03() throws Exception{
        //反射加载Driver类，动态加载，更加灵活，减少依赖性
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Driver driver = (Driver)aClass.newInstance();
        //得到连接 jdbc:mysql://ip/database_name: -- 固定模板
        String url = "jdbc:mysql://localhost:3306/test2";
        String user = "root";
        String password = "123";
        //使用DriverManager
        DriverManager.registerDriver(driver);
        Connection connect = DriverManager.getConnection(url,user,password);
        System.out.println(connect);
    }
    @Test
    public void Connect04() throws Exception{ //使用这个最多
        //反射加载Driver类，动态加载，更加灵活，减少依赖性
        Class.forName("com.mysql.cj.jdbc.Driver");
        //得到连接 jdbc:mysql://ip/database_name: -- 固定模板
        String url = "jdbc:mysql://localhost:3306/test2";
        String user = "root";
        String password = "123";
        //使用DriverManager
        Connection connect = DriverManager.getConnection(url,user,password);
        System.out.println(connect);
    }
    @Test
    public void Connect05() throws Exception{
        //通过Properties对象获取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\com\\day11\\source\\mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}
