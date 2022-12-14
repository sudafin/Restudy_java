package com.day5;

public class StaticInner {
    public static void main(String[] args) {
        Outer4 outer4 = new Outer4();
        outer4.test();

        Outer4.Inner4 outer41 = new Outer4.Inner4(); //直接访问的方法
        outer41.Say();
    }
}
class Outer4{
    static class Inner4{
        public void Say(){
            System.out.println("Say");
        }
    }
    public void test(){
        Inner4 inner4 = new Inner4();
        inner4.Say();
    }
}