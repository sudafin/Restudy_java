package com.day6;
/*
  异常Exception：1、异常事件两大类 a、Error（Stackoverflow，out of memory） b、Exception：编译异常和运行异常
                2、try{ 执行的主程序是否有异常 }catch(){ 如果有异常就抛出异常 }finally{ 不管有没有异常都要执行 }
                 如果要catch多个异常，需要将父类Exception放在后面；
                3、throws异常：需要写在方法后，是JVM抛出的异常，只要被重写或者被引用的方法是编译异常那么也需要抛出异常
                4、自定义异常一般继承RunTimeException（运行时异常），且使用throw抛出异常
                   CustomizeException
  包装类：1、继承了Number（long，int，double，short）；boolean；char；
         2、手动拆箱、手动装箱和自动拆箱、自动装箱 Integer_ (可以相互转换两种类型)
  String类： 1、String s = new String("") <-先指向的是堆内存在指向常量池  String s = "" <-直接指向的是常量池 其中两个s都是是在栈内存
            2、equals比较的是地址所以不管是堆内存还是常量池只要地址相同就相等；==比较的是对象所指的内存所以两者不相等
            3、重点---String的值的地址在放在常量池且是不可改变的，也就是如果重新赋值就是重新在常量池创建一个新的地址
            4、String方法：
               String [] s1 = s.split(" ")以什么为分割，并放到String数组里，如果有特殊字符需要加转义符\
               如以\\为分割那么split("\\\\")就要这样，每个特殊字符前面加一个转移字符\
               replace方法 ；String a1 =s.replace(sour,dest);需要用新的String来接收
            5、StringBuffer类：代表的是可变的字符序列，可以对字符串内容进行增删（append，delete，insert）不改变地址，且在存放堆内存中
              String_类 注意：打印StringBuffer时会自动使用toString方法；
              delete方法(int a,int b):a<=index<b 删除这个范围索引的字符；
              insert(int a,"s")，在a索引下插入s；
            6、StringBuilder类：跟Buffer的方法一致是简易替换，比Buffer更快，用于单线程，因为线程不安全，因为没有同步字关键词


 */
public class day6 {
    public static void main(String[] args) {
    }
}
