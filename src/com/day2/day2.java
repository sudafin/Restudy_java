package com.day2;

public class day2 {
    /*
    ① OverLoad：在一个类中，同一个方法名，但形参要求不一样，返回类型无要求，修饰符无要求；
    ② 可变参数：方法重载下的基础下形参多数化，且可变参数的实参为数组；
              如要将可变参数与其他参数放在一起，可变参数在最后，且不能有多个类型的可变参数；
    ③ 全局与局部：在类中的全局变量可以通过调用对象在其他类中使用，而类中的局部变量则不能通过调用对象使用
               全局变量可以加修饰符，局部变量不能加修饰符；
    ④ 构造器(构造方法)：方法名与类名一致，无返回类型，有修饰符（public private final）可方法重载；
                     构造器是完成对象的初始化，不是创建对象且系统自动调用，不能主动用调用；
                     无主动创建构造器的时候，系统自动创建一个无参无修饰符的默认构造器；
    ⑤ 对象创建流程：在 对象创建.jpg 中
    ⑥ this: 在堆创建一个指向自己对象的地址，且地址与自己对象相同；
             既this表示的是自己调用自己；这表明this可以访问本类的属性（成员变量），成员方法，
             构造器（只能在构造器里调用其他构造器，且放置第一条语句，语法：this()）；
             用于区分当前类的属性和局部变量；且不能在类外和类中不是构造器和成员方法中使用；
    ⑦ 访问修饰符：public：对外公开  （同/本类 同包 子类 不同包）
                protected：对子类和同一个包中的类公开  （同类 同包 子类 不同包）
                默认：没有修饰符，向同一个包的类公开   （同类 同包）
                private：只有类本身可以访问，不对外开放  （同类）

    */
    public static void main(String[] args) {
        //方法重载
        ToCalculate mc = new ToCalculate();
       int a = mc.calculate(1,2);
       double b = mc.calculate(1.2,3.3);
       double c =  mc.calculate(1.2,1); //2.2
       double d = mc.calculate(1,1.2);  //2.2

        //可变参数
        new_ToCalculate me = new new_ToCalculate();
        System.out.println(me.calculate(1,2,3,4,5));

        //构造方法
        Dog d1 = new Dog(20);
        Dog d2 = new Dog(10,"mike");
        System.out.println(d1.age + " "+ d1.name); //20 null
        System.out.println(d2.age + " "+ d2.name); //10 mike

        //this关键字
        Cat c1 = new Cat();
        c1.Park();

        //修饰符
        ToTest totest = new ToTest();
        System.out.println(totest.d1 + totest.d2 + totest.d3);
    }
}
class ToCalculate{
    public int calculate(int x,int y){
        return x + y;
    }
    public double calculate(double x,double y){
        return x + y;
    }
    public double calculate(double x,int y){
        return x + y;
    }

}

class new_ToCalculate{
    int sum;
    public int calculate(int...nums){
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}

class Dog{
    int age;
    String name;
    public Dog(int d_age,String d_name){
       age = d_age;
       name = d_name;
    }
    Dog(int d_age){
       age = d_age;
    }
}

class Cat{
    String name;
    int age;
    public Cat(int age, String name){
        this.age = age;
        this.name = name;
        System.out.println("构造器方法①");;
    }
    public Cat(){
        this(10,"小人");
        System.out.println("构造器方法②");
        System.out.println(name+ "" + age);
    }
    public void Run(){
        System.out.println("Cat run to Park");
    }
    public void Park(){
        System.out.println("Cat want to Park");
        this.Run();
    }

}

class ToTest{
    public int d1 = 10;
    protected int d2 = 20;
    int d3 = 30;
    private final int d4 =10;
    void test(){
        System.out.println(d1 + d2 +d3 +d4);
    }
}
