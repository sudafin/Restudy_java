package com.day8;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddress_o{
    public static void main(String[] args) throws UnknownHostException {
        new InetAddress_o().InetAddress_();
    }
    public void InetAddress_() throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getLocalHost();//本机的名字和IP地址
        System.out.println(inetAddress);
        InetAddress byName = InetAddress.getByName("LAPTOP-4GRT2K57");
        System.out.println(byName);
        InetAddress byName1 = inetAddress.getByName("www.baidu.com");
        String hostAddress = byName1.getHostAddress();
        System.out.println(hostAddress);
        String hostName = byName1.getHostName();
        System.out.println(hostName);

    }
}
