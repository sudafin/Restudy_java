package com.day5;

public class MemberInner {
    public static void main(String[] args) {
        Inner3 inner3 = new Inner3();
        inner3.test();
        Inner3.Outer3 inner31 = inner3.new Outer3();//直接访问的方法
        inner31.Say();
    }
}
class Inner3{
    public class Outer3{
        public void Say(){
            System.out.println("say");
        }
    }
    public void test(){
        Outer3 outer3 = new Outer3();
        outer3.Say();
    }
}