# MySQL操作（利用Navicat）：db_name - 数据库名字; table_name - 表名; keyName - 字段数据

## 1、数据库

   创建数据库：CREATE DATABASE db_name CHARACTER SET utf8;
            CREATE DATABASE db_name CHARACTER SET utf8 COLLATE utf8_bin;
            CHARACTER SET后面带编码； COLLATE后面带校对规则，如果不加则默认不区分大小写，如果加_bin则区分大小写；
   删除数据库：DROP DATABASE db_name;
   查看数据库：SHOW DATABASES; 查看所有的数据库
            SHOW CREATE DATABASE db_name; 查看单个创建的数据库
   备份数据库（在命令行执行）：mysqldump -u root -p -B db_name > 目录(I://s.sql)
   恢复数据库：source 目录(得进去mysql里面执行)

## 2、创建表： 

        CREATE TABLE `user1`(
            'id' INT NOT NULL DEFAULT 10, --如果值为NULL则默认值为10
            `name` VARCHAR(255) ,--keyName dataType(dataLength)
            `password` VARCHAR(32),
            `birthday` DATE)
            CHARACTER SET utf8 COLLATE utf8_bin ENGINE INNODB;
    数据类型：dataType1.png dataType2.png
    重命名表：Rename table old_table_name to new_table_name;
    查看表类型（不能查看数据）：DESC table_name
    修改表：①添加
            ALTER TABLE table_name
             ADD keyName dataType(data)
          ②删除
            ALTER TABLE table_name
              DROP keyName
          ③修改
            ALTER TABLE table_name
              MODIFY keyName dataType (data)

## 3、CURD：增删改查 

  ①增：
    INSERT INTO `table_name` (keyName....)
     VALUES(keyName....),
          (keyName....);
    注意：插入类型要与字段的类型一致； 输入的数据的长度要在规定的数据长度范围；
         字符和日期应该在单引号下； 可以插入空值，前提是运行该字段为空；
  ②改：
    UPDATE `table_name`
    SET DestKeyName = data  --需要修改的数据
       WHERE NeedKeyName = data;  --修改的对象（需要其中的特定数据，通常是名字或ID）
  ③删：
    DELETE FROM `table_name`
       WHERE  DestKeyName = Data;
  ④查：
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

## 4、常用函数：

  ①统计函数：
   a、count:SELECT COUNT(*) FROM table_name --返回满足条件的记录的行数 
            SELECT COUNT(keyName) FROM table_name --返回满足条件的行数，排除NULL的情况
   b、sum:SELECT SUM(keyName) FROM table_name --总数
   c、avg:SELECT AVG(keyName) FROM table_name --平均数
   d、max/min:SELECT MAX(keyName),MIN(keyName) FROM table_name -- 最高分和最低分
  ②分组统计：
    SELECT keyName....  --通常有2个以上的keyName组成 一个是特定的数据 比如平均值或者max/min，**不能是普通的keyName** 一个是加上特定keyName 比如分组或类别
        FROM table_name GROUP BY keyName  --通过这个类别来进行分组计算特定数据
        HAVING condition; --条件 比如平均值＞？
  ③字符串函数：StringFunction.png
    SELECT CONCAT(keyName1," is ",keyName2) FROM table_name --keyName1 is keyName --连接
    SELECT UCASE(keyName) FROM table_name --变大写
    SELECT LCASE(keyName) FROM table_name --变小写
    SELECT LENGTH(keyName) FROM table_name --得到长度
    SELECT REPLACE(keyName,keyName_data,transform_data) FROM table_name --替换数据 (Able,"Good"(原有的),'good'(替换的))
    SELECT SUBSTRING(keyName,position1,position2) FROM table_name --得到全部列中keyName的position1到position2的字母 
  ④数学函数:Math.png
  ⑤日期函数:Date.png
  ⑥加密函数:pwd.png
  ⑦流程函数:control.png

## 5、多表

   ①查询加强：
    SELECT * FROM table_name
      GROUP BY keyName
        HAVING condition
            ORDER BY keyName
                LIMIT 每页显示记录数*(第几页-1),每页显示的记录数  --0,2 表示得到1，2行数据形成第一页;2,2表示得到3，4行数据形成第二页
    eg:
    SELECT `Group` ,ID, `Name` ,SUM(Math + Chinese+English) AS total FROM student
        GROUP BY `Group`,ID,`Name`
            HAVING total > 154
                ORDER BY `Group` DESC,ID DESC
                   LIMIT 0,2
    