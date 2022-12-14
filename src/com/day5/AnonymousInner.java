package com.day5;

public class AnonymousInner {
    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        outer2.Inner2();
        ToInterface toInterface = new ToInterface();
        toInterface.Person(new Interface() { // 不是动态绑定要按正常创建对象来
            @Override
            public void fight() {
                System.out.println("to fight");
            }
        });
    }
}
class Outer2{
    public void Inner2(){
        test1 test1 = new test1(){
            @Override
            void cry() {
                System.out.println("to cry");
            }
        };
        test2 test2 = new test2(){
            @Override
            public void swim() {
                System.out.println("to swim");
            }
        };
        test3 test3 = new test3(){
            @Override
            public void fly() {
                super.fly();
                System.out.println("inner fly");
            }
        };
        test1.cry();
        test2.swim();
        test3.fly();
    }

}
abstract class test1{
    abstract void cry();
}
interface test2{
    void swim();
}
class test3{
    public test3(){
        System.out.println("test3");
    }
    public void fly(){
        System.out.println("test3 fly");
    }
}

interface Interface{
    void fight();
}
class ToInterface{
    public void Person(Interface in){
        in.fight();
    }
}