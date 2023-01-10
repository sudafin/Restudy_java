# MySQL操作（利用Navicat）：db_name - 数据库名字; table_name - 表名; keyName - 字段数据

## 一、数据库

 ### ①创建数据库：
    CREATE DATABASE db_name CHARACTER SET utf8;
    CREATE DATABASE db_name CHARACTER SET utf8 COLLATE utf8_bin;
    CHARACTER SET后面带编码； COLLATE后面带校对规则，如果不加则默认不区分大小写，如果加_bin则区分大小写；
 ### ②删除数据库：
    DROP DATABASE db_name;
 ### ③查看数据库：SHOW DATABASES; 查看所有的数据库
    SHOW CREATE DATABASE db_name; 查看单个创建的数据库
 ### ④备份数据库（在命令行执行）：
    mysqldump -u root -p -B db_name > 目录(I://s.sql)
 ### ⑤恢复数据库：
    source 目录(得进去mysql里面执行)

## 二、表：

 ### ①创建表:  
        CREATE TABLE `user1`(
            'id' INT NOT NULL DEFAULT 10, --如果值为NULL则默认值为10
            `name` VARCHAR(255) ,--keyName dataType(dataLength)
            `password` VARCHAR(32),
            `birthday` DATE)
        CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB;
 ### ②数据类型：
        dataType1.png dataType2.png
 ### ③重命名表：
        Rename table old_table_name to new_table_name;
 ### ④查看表类型（不能查看数据）：
        DESC table_name
 ### ⑤修改表的数据：
        a、添加
            ALTER TABLE table_name
              ADD keyName dataType(data)
        b、删除
            ALTER TABLE table_name
              DROP keyName
        c、修改
            ALTER TABLE table_name
              MODIFY keyName dataType (data)
 ### ⑥删除整个表：
        DROP TABLE table_name

## 三、CURD：增删改查

 ### ①增：
    INSERT INTO `table_name` (keyName....)
        VALUES(keyName....),
        (keyName....);
    注意：插入类型要与字段的类型一致； 输入的数据的长度要在规定的数据长度范围；
    字符和日期应该在单引号下； 可以插入空值，前提是运行该字段为空；
 ### ②改：
    UPDATE `table_name`
        SET DestKeyName = data  --需要修改的数据
        WHERE NeedKeyName = data;  --修改的对象（需要其中的特定数据，通常是名字或ID）  
 ### ③删：
    DELETE FROM `table_name`
        WHERE  DestKeyName = Data;
 ### ④查：
    a、SELECT KeyName.... FROM table_name； --可重复的数据
    b、SELECT DISTINCT KeyName.... FROM table_name； --不可重复的数据,如果有多个数据，只能多个数据相同才会省略
    c、SELECT KeyName AS new_KeyName,((INT)KeyName1+KeyName2+KeyName3) AS new_KeyName FROM table_name;
    -- . AS . 重命名为新的名字；keyName+.....相加
    d、where字句用法：where.png
    模糊查找：SELECT * FROM table_name
    WHERE keyName LIKE '关键词%
    e、 排序
    SELECT * FROM table_name
    ORDER BY keyName ASC; --ASC是升序（默认DESC是降序；可以控制两个keyName以上排序，第一个排列完再后一个；

## 四、常用函数：

 ### ①统计函数：
    a、count:SELECT COUNT(*) FROM table_name --返回满足条件的记录的行数
             SELECT COUNT(keyName) FROM table_name --返回满足条件的行数，排除NULL的情况
    b、sum:SELECT SUM(keyName) FROM table_name --总数
    c、avg:SELECT AVG(keyName) FROM table_name --平均数
    d、max/min:SELECT MAX(keyName),MIN(keyName) FROM table_name -- 最高分和最低分
 ### ②分组统计：
    SELECT keyName....  --通常有2个以上的keyName组成,可以是COUNT,平均数....
        FROM table_name
         GROUP BY keyName....  --通过SELECT的keyNam来进行分组(SELECT有多少个字段这里也得是多少个)
          HAVING condition; --条件 比如平均值＞？
 ### ③字符串函数：StringFunction.png
        SELECT CONCAT(keyName1," is ",keyName2) FROM table_name --keyName1 is keyName --连接
        SELECT UCASE(keyName) FROM table_name --变大写
        SELECT LCASE(keyName) FROM table_name --变小写
        SELECT LENGTH(keyName) FROM table_name --得到长度
        SELECT REPLACE(keyName,keyName_data,transform_data) FROM table_name --替换数据 (Able,"Good"(原有的),'good'(替换的))
        SELECT SUBSTRING(keyName,position1,position2) FROM table_name --得到全部列中keyName的position1到position2的字母
 ### ④数学函数:Math.png
 ### ⑤日期函数:Date.png
 ### ⑥加密函数:pwd.png
 ### ⑦流程函数:control.png

## 五、多表

 ### ①查询加强：
       SELECT * FROM table_name
         GROUP BY keyName
          HAVING condition
           ORDER BY keyName
             LIMIT 每页显示记录数*(第几页-1),每页显示的记录数  --0,2 表示得到1，2行数据形成第一页;2,2表示得到3，4行数据形成第二页
        eg:
        SELECT `Group` ,ID, `Name` ,SUM(Math + Chinese + English) AS total FROM student
            GROUP BY `Group`,ID,`Name`
             HAVING total > 154
              ORDER BY `Group` DESC,ID DESC
               LIMIT 0,2
 ### ②多表笛卡尔集：
      SELECT keyName1,keyName2 FROM table_name1,table_name2 --两个表会进行拼接，每一条会进行组合，行数等于两个表的相乘;
          WHERE table.name1.keyName3 = table.name2.keyName3; --条件判断，表示只要相等就显示keyName1，keyName2：
      SELECT keyName1,keyName2,table.name1.keyName3 FROM table_name1,table_name2 
          WHERE table.name1.keyName3 = table.name2.keyName3; 
 ### ③自连接(一张表变为两张表):
        SELECT new_Name1.keyName AS " " ,new_Name2.keyName AS " " 
        FROM table_name new_Name1,table_name new_Name2
        WHERE new_Name1.keyName(这个keyName是属于table_Name的) = new_Name2.keyName
        eg:(将老师与它的研究老师绑定)SELECT worker.`Name` AS "老师" ,boss.`Name` AS "研究老师"
             FROM teacher worker,teacher boss 
             WHERE worker.ID = boss.mgr
        数据：TeacherData.png
 ### ④子查询(已经自身的某个数据来寻找全部的数据) 
        SELECT * FROM table_name
        WHERE keyName1 =
        (SELECT keyName1
        FROM table_Name
        WHERE keyName2 = "")
       --寻找keyName1的数据，通过递归，先寻找已经知道的keyName1的keyName2，最后来找到keyName1所在的全部数据;
     eg：(通过已经的Name来寻找全部Group数据)SELECT * FROM teacher
         WHERE `Group` =
         (SELECT `Group`
         FROM teacher
         WHERE `Name` = "白华")
 ### ⑤all和any 
      ALL相当于MAX ANY相当于MIN
      ALL:SELECT name,Math,`Group` FROM student
          WHERE Math > ALL(
          SELECT Math
          FROM student
          WHERE  `Group` = 2
          )
       --找出一组比Group = 2大的Group的对象
      ALL:SELECT name,Math,`Group` FROM student
          WHERE Math > ANY(
          SELECT Math
          FROM student
          WHERE  `Group` = 2
        )
        --找出一组比Group = 2中小的Group(包括Group = 2)的对象
 ### ⑥多列子查询(用多个条件去寻找符合相同条件的对象)：
          SELECT * FROM teacher
          WHERE (`Group`,`Subject`) = (
                    SELECT `Group`,`Subject` 
                     FROM teacher 
                     WHERE ID = 3
               ) 
               --用Group和Subjec来寻找ID=3的对象同一个条件的其他对象
 ### ⑦表复制和去重
          表重复：
            CREATE TABLE new_table_name LIKE old_table_name --拥有重复的数据类型
            INSERT INTO new_table_name
                (keyName....)
                 SELECT keyName.... FROM old_table_name
          去重：
            CREATE new_table_name LIKE student 
            INSERT INTO new_table_name SELECT DISTINCT *FROM student
            --将student 的数据 复制到 new_table_name 两次
    
            CREATE old_table_name LIKE new_table_name
            INSERT INTO old_table_name SELECT DISTINCT *FROM new_table_name
            --将new_table_name的数据用 DISTINCT 关键词不带重复 的 复制到 new_table_name
         
            DELETE FROM new_table_name -- 清除 new_table_name的数据
            INSERT INTO new_table_name SELECT  *FROM old_table_name -- 将无重复的old_table_name 重新复制到 new_table_name
            DROP TABLE old_table_name --最后删除old_table_name
 ### ⑧合并查询(将同一个对象的多个查询结果合并成一条查询结果)
      UNION:去掉重复   UNION ALL:不去掉重复行
      SELECT ID FROM student
      UNION ALL
      SELECT `Name` FROM student
 ### ⑨外连接需求(不用where语句将两张表相连)：
      (将两张表分为左右表)
      左/右外连接：左/右侧的表完全显示,即使为空
        SELECT keyName,KeyName
			FROM table_name1 LEFT/RIGHT JOIN table_name2
			   ON table_name1.ID = table_name2.ID

## 六、约束

 ### ①主键(被定义主键的字段不能有重复数据)：  
       字段名 字段类型 primary key
       --ID INT PRIMARY KEY;
         ID INT, Name VARCHAR(255),PRIMARY KEY(ID,Name);
       注意：a、primary key 不能重复而且不能为NULL
            b、一张表最多只能有一个主键，但可以是复合主键
            c、主键的定义方式有两种 --直接在字段名后指定 or 在表定义最后写primary key(列名) <-这个是复合主键;
            d、使用desc表名，可以看到primary key的情况
 ### ②非空：
       字段名 字段类型 NOT NULL --ID INT NOT NULL;
 ### ③unique(唯一，不能重复的数据)：
       字段名 字段类型 UNIQUE --ID INT UNIQUE;
       注意：a、可以为NULL
            b、一张表可以多个unique
 ### ④外键：
       解释：分为主表和外键所在表，两张表有一个共同的key的数据，外表存在的key的数据用来连接主表存在的key的数据，
            只有外表有存在(主表存在的key的)数据，外表才能保存对象，不然创建失败；要想删除主表的对象先删除外表所在的同一对象；
       注意：a、外键所向的表的字段，要求是primary key或者是unique
            b、表的类型是innodb，这样的表才支持外键
            c、外键的字段的类型要与主键的类型一致（长度可以不同）
            d、外键字段的值，必须在主键字段中出现过，或者为NULL(前提是外键字段允许为NULL)
            e、一旦建立主外键的关系，数据不能随意删除了
       语法：
        FOREIGN KEY (外键的key) REFERENCES 主表 (主键的key)
        eg：CREATE TABLE test1_table --主表
            (
            class_ID INT PRIMARY KEY,
            `name` Varchar(255)
            );
            CREATE TABLE test2_table --外表
            (
            ID INT PRIMARY KEY ,
            class_ID INT,
            `name` varchar(255),
            FOREIGN KEY (CLASS_ID) REFERENCES TEST1_TABLE(CLASS_ID) --组合
            );
 ### ⑤check(mysql5.7只是语法校验，不会生效)
          字段名 字段类型 CHECK( conditon );
          在创建表的时候对数据进行约束;

## 七、自增长和索引(唯一的，频繁的，经常不更新的，不在where字句的字段适合创建索引)

 ### ①自增长
      a、一般来说增长是和primary key配合使用，且插入数据时一般为NULL（从1开始自增，每添加数据加一）;
      b、自增长也可以单独使用
      c、自增长修饰的字段为整数型
      d、自增长默认为1开始，可以通过alter table_name auto_increment = 新的开始值
      e、如果添加数据时，给自增长字段指定非NULL值，则以该值为数据
      CREATE TABLE table_name(
        keyName INT PRIMARY KEY AUTO_INCREMENT
      );
 ### ②索引机制
      无索引时每一次找数据到会进行全盘扫描
      有索引时是形成一棵二叉树
      优点：查询更加快速  缺点：删除，增加，改变变慢，磁盘的占用也会变大
 ### ③创建索引
      索引类型：
      a、唯一索引：索引不会重复
         CREATE UNIQUE INDEX index_name ON table_name(keyName)
      b、普通索引：索引会重复
         CREATE INDEX index_name ON table_name(keyName)
      c、主键索引
         CREATE TABLE table_name(keyName INT);
         ALTER TABLE table_name ADD PRIMARY KEY(keyName)
 ### ③删除索引
      a、普通
      DROP INDEX index_name ON table_name
      b、主键
      ALTER TABLE table_name DROP PRIMARY KEY
 ### ④查询索引
      a、
      SHOW INDEXE FROM table_name
      b、
      SHOW INDEXES FROM table_name
      c、
      SHOW KEYS FROM table_name

## 八、事务和存储引擎

 ### ①事务的概念
        事务是用于保证数据的一致性，它由一组相关的dml语句组成，该组的dml语句要么全部成功，要么全部失败
        如：转账要用事物来处理，用以保证数据的一致性 
        加锁：如果一个事务增删改没有提交操作，那么另一个事务就不能查询数据
 ### ②事务的操作
        START TRANSACTION  -- 开始一个事务
        SAVEPOINT 保存点名 --设置保存点
        ROLLBACK TO 保存点名 --回退该保存点名的事务位置
        ROLLBACK --回退所有全部事务
        COMMIT -- 提交事务，所有的操作生效，不能回退
      eg：
        CREATE TABLE test3(
        ID INT ,
        `name` varchar(255)
        ); --创建表
        START TRANSACTION; --开始事务
        SAVEPOINT a; --设置保存a，此保存点无如何数据
        INSERT INTO TEST3 VALUES (1,'a'); --插入数据
        SAVEPOINT b; -- 设置保存b，此保存点有(1,'a')一条数据
        INSERT INTO TEST3 VALUES (2,'b'); --插入第二条数据
        ROLLBACK TO b; --回退到b
        ROLLBACK TO a; --回退到a
        注意：回到a后就不能回退到b
 ### ③事务隔离级别(只有开始事务才有隔离等级)
        概念：多个连接开启各自事务操作数据库中数据时，数据库要负责隔离操作，以保证各个连接在获取数据时的准确性
             如果不考虑隔离性，可能会引起以下问题：
             脏读 --一个事务插入没有提交，却在另一个事务看到插入且没提交的数据
             不可重复读、幻读 --一个事务修改没有提交，却在另一个事务看到修改且没提交的数据
        四种隔离级别：              脏读     不可重复读    幻读      加锁读
        读未提交(Read uncommitted)  √          √         √       不加锁
        读已提交(Read committed)    ×          √         √       不加锁 
        可重复读(Repeatable read)   ×          ×         ×       不加锁
        可串行化(Serializable)      ×          ×         ×        加锁  --隔离强度最强
        查看事务等级：SELECT @@tx_isolation; --当前会话(某个用户)  SELECT @@global.tx_isolation;--当前系统(整个用户)
        设置事务等级：SET SESSION TRANSACTION ISOLATION LEVEL REPEATBLE READ; --当前会话
                    SET GLOBAl SESSION TRANSACTION ISOLATION LEVEL REPEATBLE READ; --当前系统
        mysql默认的级别是可重复读
 ### ④存储引擎
       类型：EngineType.png

## 九、视图和用户管理、权限
   
 ## ①视图概念（用来保留基表的部分信息）：
      视图是一个虚拟表，其内容由查询定义。同真实的表一样，视图包含列，其数据来自对应的真实表（基表）
      视图和基图的关系：一一映射的关系；视图来自基表（可多个），基表和视图的改变是互相影响的
 ## ②视图的使用和细节：
      使用：
        CREATE VIEW view_name AS SELECT keyName....(来自table_name) FROM table_name; --创建视图
        ALTER VIEW view_name AS SELECT keyName FROM table_name; --更新视图的数据
        SHOW CREATE VIEW view_name; --查看视图的结构信息
        DESC view_name; --查看视图的类型信息
        SELECT * FROM view_name --查看视图的数据信息
        DROP view view_name;  --删除视图
 ## ③MySQL用户管理(根据不同的开发人员，赋予相应的操作权限)     
      创建用户: CREATE USER '用户名' @ '登录IP' IDENTIFIED BY '密码'    
      删除用户: DROP USER '用户名' @ '登录IP'
      修改自己密码: SET PASSWIRD = PASSWORD(' ')
      修改其他人的密码(需要权限): SET PASSWORD FOR '用户名' @ '登录IP' = PASSWORD(' ') 
 ## ④MySQL权限管理
      基本语法：GRANT 权限列表 ON 库.表对象名 TO '用户名' @ '登录IP' [IDENTIFIED BY '密码' ]
      回收语法：REVIKE 权限列表 ON 库.表对象名 FROM '用户名' @ '登录IP'
      权限列表：Permissions.png
      IP：192.168.1.% -- 表示符合192.168.1的IP都可以进入