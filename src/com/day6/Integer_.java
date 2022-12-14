package com.day6;

public class Integer_ {
    public static void main(String[] args) {
        int n1 = 100;
        //手动装箱 int - Integer
        Integer a2 = Integer.valueOf(n1);
        //手动拆箱 Integer - int
        int a3 = a2.intValue();

        // 自动拆箱
        Integer a4 = 1; //本质是valueOf
        //自动装箱
        int a5 = a4;

        //Integer - String
        String k1 = String.valueOf(1); //本质是Integer.toString
        //String - Integer
        Integer k2 = Integer.parseInt(k1);
        System.out.println(k1 + 2);
        System.out.println(k2 + 2);
    }
}
