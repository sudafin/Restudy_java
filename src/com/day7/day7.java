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
 *    2、字节流：a、FileInputStream和FileOutputStream：前者是读取文件,后者写入文件 FileInputStream_FileOutputStream
 * */
public class day7 {
    public static void main(String[] args) {
    }
}
