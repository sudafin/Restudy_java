package com.day5;

public class LocalInner {
    public static void main(String[] args) {
        Outer1 outer = new Outer1();
        outer.test();
    }
}
class Outer1{
    int n = 1;
    public void test(){
        class Inner{
           int n = 2;
           public void test1(){
               System.out.println("inner："+n +"outer："+Outer1.this.n);
           }
        }
        Inner inner = new Inner();
        inner.test1();
    }
}
