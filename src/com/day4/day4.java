package com.day4;
/**
    ①equals与==的区别：==表示的地址是否相同，equals表示的是引用是否相同
    ②static:同一个类的不同对象都可以调用，遵循修饰符的原则，public static int =1
      or public static void play()->不能用this;
    ③main：程序的入口，可以访问本类中的静态方法和变量，非静态则需要实例化本类（new）
    ④代码块：代码块执行顺序（普通的代码块先于静态的）先于构造器，是对构造器的补充,每创建一次对象都执行一次
      eg；[static]{              {
          System.out.println();    System.out.println();
          System.out.println();    System.out.println();
          System.out.println();    System.out.println();
          }                       }
      一、类的加载而加载：a、创建对象加载；b、创建子类对象实例，父类也会加载；c、使用类的静态方法（静态属性、静态方法）
         普通的代码块，在创建对象时会被隐式被调用，被创建一次就被调用一次，如果只是调用类的静态成员，普通代码并不会执行
      二、构造器隐含 super（）（父类的构造器） 和 本类的代码块
      ⑤饿汉式和懒汉式：private下的构造器，饿汉式用static new了本类，而懒汉式则不用static，两者都需要用一个方法去返回值
      ⑥final：使用情况，a、不希望被继承；b、不希望父类的某个方法被子类覆盖和重写；c、不希望值被改变；
                      d、final被定义后，不能在构造器赋初值，但能在代码块初值，且不能修饰构造器
                      e、final类不能被继承，但能被实例，但如果不是final类但是final方法，可以继承不能重写
 */
public class day4 {
    public static void main(String[] args) {
        reQuals();//equals重写
    }
    public static void reQuals(){
        Person p1 = new Person("mike",20);
        Person p2 = new Person("mike",20);
        Person p3 = new Person("mike",30);
        System.out.println(p1.equals(p2)); //true
        System.out.println(p1.equals(p3)); //false
    }
}
class Person{
    private String name;
    private int age;
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;
            return this.name.equals(p.name)&&this.age==p.age;
        }
        return false;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
