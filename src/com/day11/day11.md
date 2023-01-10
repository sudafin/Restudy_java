# JDBC API:一组规范的接口，它统一和规范应用程序与数据库的连接、执行SQL语句，并得到返回结果等各类操作，相关类和接口在java.sql与javax.sql包中

## 连接数据库的5种方式
    DBC01.java
## ResultSet(查询后返回的结果集)
    表示数据库结果集的数据表，通常通过执行查询数据库的语句生成
    ResultSet对象保持一个光标指向其当前的数据行。最初，光标位于第一行之前
    next方法将光标移动到下一行，并且由于在ResultSet对象种没有更多行时返回fasle，因此可以在While循环中使用循环来遍历结果集
    JDBC02.java
## SQL注入
    Statement:用于执行静态SQL语句返回其生成的结构的对象
    可以通过Statement(存在SQL注入) PreparedStatement(预处理) CallableStatement(存储过程) 来获取对象
    因为Statement存在SQL注入(指的是利用某些系统没有对用户输入的数据进行充分的检查，而在用户输入数据中注入非法的SQL语句段或命令，从而恶意攻击数据库)
    因此开发中常使用PreparedStatement来防止SQL注入
## 预处理查询
    PreparedStatement执行的SQL语句中的参数用问好表示，调用它的对象的setXX()方法来设置参数
    set方法有两个参数，一个是设置SQL语句中的参数的索引(从1开始)，第二个设置的SQL语句中的参数的值
    executeQuery() -- 返回ResultSet对象  executeUpdate() -- 返回执行更新，包括增，删，改受影响的行数的个数
    JDBC03.java
## JDBC API
    DriverMannager --getConnection(url,user,password);
    Connection -- preparedUpdate(sql)
    Statement -- executeUpdate(sql) , executeQuery(sql), execute(sql) 执行任意的sql语句,f返回布尔值
    PreparedStatement -- setObject
    ResultSet -- next()向下移动 ,previous()向上移动 ,getXX("col_name") ,getObject()
## JDBCUtils开发
    一个工具类，完成对mysql的连接和关闭的封装
    JDBCUtils.java
    JDBC04.java
## 事务
    JDBC程序中当一个Connection对象创建时，默认情况下是自动提交事务；每一次执行一个SQL语句，如果执行成功，就会自动提交，不能回滚
    调用Connection的setAutoCommit(false)可以取消自动提交事务
    执行成功所有语句后，调用commit()提交事务，当想要回滚时，使用rollback(SavePoint),如果没有savepoint就返回setAutoCommit的位置;
    JDBC05.java
## 批处理
    当需要成批插入或更新记录时，该机制允许多条语句一次性提交给数据库进行处理
    JDBC的语句：addBatch() -- 添加需要批量处理的SQL语句或参数,executeBatch() -- 执行批量处理语句,clearBatch() -- 清除批量处理包的语句
    JDBC连接mysql时，如果要使用该功能，请再url加参数?rewriteBatchedStatements=true
    批处理往往和PReparedStatement一起搭配使用，效率大大提高
    JDBC06.java