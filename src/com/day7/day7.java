package com.day7;

import java.io.File;

/**
 * 一、线程：
 *     并发：同一个时刻，多个任务交替执行，单核cpu实现的多任务就是并发
 *     并行：同一个时刻，多个任务同时执行，多核cpu实现并行
 *    1、线程可以继承Thread和实现Runnable来使用，main方法自动有main线程；
 *    2、继承Thread：a、用类重写run方法，且在main方法中使用start方法启动，因为启动run方法就会变成单线程
 *    3、实现Runnable:a、用类实现Runnable方法，在main中创建Thread对象并将多线程的对象名放在构造体中，再用Thread对象名使用start方法；
 *       Thread_Runnable
 *    4、join方法可以实现插队功能，可以先让使用join方法的线程执行完再执行后面的线程
 *    5、守护线程：一般为工作线程服务，当所有的用户线程结束，守护线程自动结束，方法-setDaemon
 *    6、线程状态看img图；
 *    7、线程同步：同步方法非静态的锁可以是this(创建的对象)，也可以是其他对象;静态的锁是当前类的本身 xxx.class
 *              关键字synchronized修饰时，表示该对象在任一时刻只能由一个线程来访问
 *              synchronized_
 *  二、文件
 *     File创建文件 File file = new File("path"); file.createNewFile();
 *    1、IO流原理：img_1
 *    2、字节流：  FileInputStream和FileOutputStream：前者是读取文件,后者写入文件 用byte数组接受
 *               FileInputStream_FileOutputStream 缺点：不能写入中文和读出中文，优点可以复制文本和视频，图片
 *    3、字符流：FileReader 和 FileWriter 前者读取文件 后者写入文件 用char数组接受 FileReader_FileWriter 缺点：不能复制文字、视频和图片
 *    4、节点流和处理流：a、节点流可以从一个特定的数据源  读写   数据，如FileReader和FileWriter、FileInputStream和FileOutputStream；
 *                      这类是访问文件的；也有访问数组和字符串的流ByteArrayInputStream/CharArrayReader、StringReader....
 *                    b、处理流（也叫包装流）“连接”在已存在的流（节点流或处理流）之上，为程序提供更为强大的读写功能，
 *                      如BufferReader，BufferWriter；img_2.png
 *    5、缓冲流：BufferedReader_BufferedWriter BufferedInputStream_BufferedOutputStream
 *             特点和上面一样,BufferedReader构造器需要new FileReader，其他也一样可以new Buffer的子类
 * */
public class day7 {
    public static void main(String[] args) {
    }
}
