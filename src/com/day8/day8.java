package com.day8;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 网络编程:
 *   1、IP地址：由网络地址+主机地址组成；用于识别网络中的每台计算机和主机
 *       表示形式：xx.xx.xx.xx; 每一个十进制的范围：0-255
 *   2、TCP：传输控制协议；使用TCP协议之前，须先建立TCP连接，形成传输数据通道
 *           传输前，采用“三次握手”方式，是可靠的;TCP协议进行通信的两个应用进程：客户端，服务端
 *           在连接中可进行大数据量的传输；传输完毕，需释放已建立的连接，效率低；
 *    3、UDP：用户数据协议：将数据源目的封装成数据包，不需要建立连接；
 *           因无需连接故是不可靠的；发送数据结束时不需要释放资源，速度快；
 *    4、InetAddress_:获取对应的域名和主机地址
 *    5、Socket_:套接字；通信两端都要有Socket，是两台机器通信的端点；
 *              网络通信其实就是Socket间的通信；Socket允许程序把网络连接当成一个流，数据在两个Socket间通过IO传输；
 *              一般把主动发起通信的应用程序属客户端，等待通信请求的为服务端；
 *              socket.getOutputStream()/socket.getInputStream...字符流也行，两台都有这两种方法；
 *              底层是TCP/IP协议
 *    6、服务端/客户端：用OutputStream来发送信息给客户端/服务端，用InputStream来接受客户端/服务端
 *    7、UDP网络编程（了解）：
 */
public class day8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = "";
        while (!s.equals("发送结束")) {
            s = scanner.next();
            System.out.println(s);
        }
    }
}
