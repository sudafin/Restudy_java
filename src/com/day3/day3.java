package com.day3;
/*
    ① 封装：encapsulation
    ② 继承： 1、子类继承了所有的属性和方法，非私有的属性和方法可以在子类直接访问，但私有的属性和方法不能在子类直接访问，要通过父类提供的公共方法去访问
            2、子类必须调用父类的构造器，完成父类的初始化
            3、当创建子类对象时，不管使用子类的哪个构造器，默认情况下总会去调用父类的无参构造器，如果父类没有提供无参构造器，则必须在子类的构造器中用super
            去指定使用父类的哪个构造器完成对父类的初始化工作，否则编译不通过
            4、如果希望指定去调用父类的某个构造器，则显式的调用一下：super(参数列表)
            5、super在使用时，必须放在构造器第一行（super只能在构造器使用）
            6、super()和this()都只能放在构造器第一行，因此这两个方法不能共存在一个构造器中
            7、如果子类和父类有相同类型名，则需看子类有没有该类型，有则输出，如果没有就向父类查找，直到object；如果该类型被修饰为private，
              且父类也有该类型，则会被阻断，无法继续寻找；
     ③ super():super.属性名 直接查找父类的属性和方法;
     ④ Overrider：方法覆盖（重写），子类有一个方法和父类的某个方法的名称、返回类型、参数一样，这种就叫覆盖父类方法;
                  意思是如果子类继承父类，但父类和子类都存在一个相同的方法名，在创建对象调用的时候优先子类;
                  子类不能缩小父类的修饰范围 如父类是protected 则子类只能是public 和 protected 不能是默认和private;
                  子类的返回类型和父类返回类型一致，或者子类返回类型是父类的返回类型的子类；
     ⑤多态：①一个对象的编译类型和运行类型可以不一致；
             编译类型在定义对象时，就确定了，不能改变；
             运行类型是可以变化的；
             编译类型看定义时 = 号的左边，运行类型看 = 号的右边；
            ②向上转型：父类的引用指向了子类的对象
             语法：父类类型 引用名 = new 子类类型()；
             编译看左边，运行看右边；
             在调用方法、类型（编译）时只有父类的方法、属性能被调用，子类不能，在运行时方法时子类的优先调用,在运行属性是父类优先调用
            ③向下转型：子类类型 引用名 = （子类类型）父类引用
                     可以使用子类的方法，当有多个子类时使用向下转型，只能选择一个子类转型，不能同时使用多个向下转型
            ④instanceof：比较操作符，用于判断对象的运行类型是否为xx类型或xx类型的子类型
            ⑤动态绑定机制：当调用对象方法的时候，该方法会和该对象的内存地址/运行内存决定绑定
                         当调用对象属性时，没有动态绑定机制，哪里声明，哪里用
            ⑥多态数组：用多态数组来写多个引用 语法：编译类型[] 引用名 = new 运行类型[nums];
                                             引用名[nums] = new 子类;
            ⑦多态参数：参数是动态绑定,用父类的参数去绑定子类的方法，属性无效
 */
public class day3 {
    public static void main (String[] args) {
        encapsulation(); //封装
        extend_(); // 继承
        Override_();//Override
        poly();//多态
        poly_upward();//多态向上转型
        poly_toward();//多态向下转型
        instanceOf();//instanceof
        DynamicBinding();//动态绑定
        polyArray();//多态数组
        polyParameter();//多态参数
    }
    public static void encapsulation() {
        //封装
        Person person = new Person();
        person.setAge(10);
        person.setName("晓明");
        person.setWeigh(120);
        System.out.println(person.getName("晓明"));
    }
    public static void extend_(){
        Graduation graduation =new Graduation();
        System.out.println(graduation.Student_age + " " + graduation.Student_nums + " "+graduation.Student_name);
        System.out.println(graduation.GetScore()); //private如何得到数据
    }
    public static void Override_(){
        Dog dog = new Dog();
        dog.eat();//优先寻找子类
    }
    public static void poly(){
        Master tom = new Master("汤姆");
        Cat cat = new Cat("小花猫");
        Fish fish = new Fish("黄花鱼");
        tom.Feed(cat,fish);

        Pig pig = new Pig("猪八戒");
        Rich rich = new Rich("米饭");
        tom.Feed(pig,rich);
    }
    public static void poly_upward(){
        Animal_upward animal_upward = new Sheep();
        animal_upward.eat();//Animal_upward_eat
        animal_upward.sleep();//Sheep_sleep
//        animal_upward.jump(); 不行
        System.out.println(animal_upward.count); // 10
    }
    public static void poly_toward(){
        Animal_toward animal_toward = new Duck();
        Duck duck = (Duck) animal_toward;
        duck.sleep();
        duck.swimming();
    }
    public static void instanceOf(){
        Animal_upward animal_upward = new Sheep();
        System.out.println(animal_upward instanceof Animal_upward);//true
        System.out.println(animal_upward instanceof Sheep);//true
    }
    public static void DynamicBinding(){
        AA aa = new BB();
        System.out.println(aa.sum()); //30 方法找运行
        System.out.println(aa.sum1());//20 属性找自身
    }
    public static void polyArray(){
        Personal[] personals = new Personal[5];
        personals[0] = new Personal("Mike",12);
        personals[1] = new Teacher("Jack",23,5000);
        personals[2] = new Teacher("John",33,7000);
        personals[3] = new Coder("kobe",27,1);
        personals[4] = new Coder("Hoke",33,5);
        for(Personal i:personals){
            System.out.println(i.Say());
            if(i instanceof Teacher){
                System.out.println(((Teacher) i).teach());//((Teacher)i)等于 Personal teacher =new Teacher();
            }
            else if(i instanceof Coder){
                System.out.println(((Coder)i).Code());
            }
        }
    }
    public static void polyParameter(){
        Worker mike = new Worker("mike", 2000);
        Manager tom = new Manager("Tom", 2000, 30);
        day3 day3 = new day3();
        day3.showEmpAnnual(mike);
        day3.showEmpAnnual(tom);
        day3.showWork(mike);
        day3.showWork(tom);
    }
        public void showEmpAnnual(Employee e){
            System.out.println(e.getAnnual());
        }
        public void showWork(Employee e){
          if(e instanceof Worker ){
              ((Worker) e).work();
          }
          else if(e instanceof Manager){
              ((Manager)e).manger();
          }
        }

}

class Person{
    public String name;
    private int age;
    private double weigh;

    public Person() {
    }

    public Person(String name, int age, double weigh) { //构造器也能用set的方法限制输入
        setName(name);
        setAge(age);
        setWeigh(weigh);
    }

    public String getName(String root) { //设置访问权限
        if(root.equals("晓明")) {
            return name;
        }else return "wrong";
    }

    public void setName(String name) {
        if(name.length() >= 1 && name.length() <=6){
        this.name = name;
        }else {
            System.out.println("you input wrong");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age>=1&&age<=100) {
            this.age = age;
        }else System.out.println("you input wrong");
    }

    public double getWeigh() {
        return weigh;
    }

    public void setWeigh(double weigh) {
        this.weigh = weigh;
    }
}

class Student {
    public int Student_age;
    String Student_name;
    protected int Student_nums;
    private int Student_score;
    public Student (){
        System.out.println("Student");
    }
    public void setAge(int age) {
        this.Student_age = age;
    }

    public void setName(String name) {
        this.Student_name = name;
    }

    public void setNums(int nums) {
        this.Student_nums = nums;
    }

    public void setScore(int score) {
        this.Student_score = score;
    }
    public void modifyScore(int score){ //通过public方法来修改private的数据
        setScore(score);
    }
    public int GetScore(){
        return Student_score; //通过public方法来获得private的数据
    }
}
class Graduation extends Student{
    public Graduation(){ //用构造器去修改数据不能用方法
        super();//默认调用父类无参构造器，当父类是有参构造器则需要在子类构造器调用super；
        Student_age = 12;
        Student_name = "ming";
        Student_nums = 2112;
        modifyScore(100);//private如何修改数据
    }
}

class Animal_Override{
    public void eat(){
        System.out.println("eat food");
    }
}
class Dog extends Animal_Override{
    public void eat(){
        System.out.println("eat good food");
    }
}

class Master{
    private String name;
    public Master(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void Feed(Animal animal,Food food){
        System.out.println("主人" + name + "给" + animal.getName() + "吃" + food.getName());
    }
}
class Animal{
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Food{
    private String name;
    public Food(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }
}
class Pig extends Animal{
    public Pig(String name){
        super(name);
    }
}
class Fish extends Food{
    public Fish(String name){
        super(name);
    }
}
class Rich extends Food{
    public Rich(String name){
        super(name);
    }
}

class Animal_upward{
    public void eat(){
        System.out.println("Animal_upward_eat");
    }
    public void sleep(){
        System.out.println("Animal_upward_sleep");
    }
    int count = 10;
}
class Sheep extends Animal_upward{
    public void sleep(){
        System.out.println("Sheep_sleep");
    }
    public void jump(){
        System.out.println("Sheep_jump");
    }
    int count =20;
}

class Animal_toward{
    public void eat(){
        System.out.println("Animal_toward_eat");
    }
    public void sleep(){
        System.out.println("Animal_toward_sleep");
    }
}
class Duck extends Animal_toward{
    public void swimming(){
        System.out.println("duck_swimming");
    }
    public void sleep(){
        System.out.println("duck_sleep");
    }
}

class AA{
    public int i = 10;
    public int sum(){
        return getI()+10;
    }
    public int sum1(){
        return i+10;
    }
    public int getI(){
        return i;
    }
}
class BB extends AA{
    public int i = 20;
    public int getI(){
        return i;
    }
}

class Personal{
    private String name;
    private int age;

    public Personal(String name, int age) {
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
    public String Say(){
        return name + "\t" + age;
    }
}
class Teacher extends Personal{
    private int salary;

    public Teacher(String name,int age, int salary) {
       super(name,age);
       this.salary = salary;
    }
    public String teach(){
        return "teach some students";
    }
    public String Say(){
        return super.Say() + "\t" + salary;
    }
}
class Coder extends Personal{
    private int Top;
    public Coder(String name, int age,int Top) {
        super(name, age);
        this.Top = Top;
    }
    public String Code(){
        return "he is coding";
    }
    public String Say(){
        return super.Say() +"\t"+ Top;
    }
}

class Employee{
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public double getAnnual(){
        return salary * 12;
    }
}
class Worker extends Employee{
    public Worker(String name, double salary) {
        super(name, salary);
    }
    public void work(){
        System.out.println("普通员工 "+getName()+" is working");
    }
    public double getAnnual(){
        return super.getSalary();
    }
}
class Manager extends Employee{
    private double bonus;

    public Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }
    public void manger(){
        System.out.println("经理 "+getName() +" is manging");
    }
    public double getAnnual(){
        return super.getSalary()+bonus;
    }
}