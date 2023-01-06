package com.day9;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressWarnings({"all"})
public class Reflection_Class {
    public static void main(String[] args) throws Exception{
        Class aClass = Class.forName("com.day9.Car");//生成一个Car类; 第一种创建模式
        System.out.println(aClass);//打印class com.day9.Car
        System.out.println(aClass.getClass());//在类加载过程中 -class java.lang.Class
        Class bClass = Car.class;
        Object o = aClass.newInstance();//创建了一个car的对象;
        Constructor constructor = aClass.getConstructor();//只能得到public类的构造器
        Constructor declaredConstructor = aClass.getDeclaredConstructor(int.class,String.class);//得到全部的构造器；
        declaredConstructor.setAccessible(true);//爆破，得到private的访问权限;
        Object Car1 = declaredConstructor.newInstance(1,"Car1");
        System.out.println(Car1);
        System.out.println("---------------");
        Field declaredField = aClass.getDeclaredField("age");//根据字符得到字段
        declaredField.set(o,3);//赋值
        Object getFileAge = declaredField.get(o);//得到值
        System.out.println(getFileAge);
        System.out.println("----------------");
        Method getSetState = aClass.getDeclaredMethod("setState",int.class);//根据名字找方法，如果有参数就写在后面
        Method getGetState = aClass.getDeclaredMethod("getState");
        Method getMethodAge = aClass.getDeclaredMethod("getAge");
        Object getAge = getMethodAge.invoke(o);
        Object setState = getSetState.invoke(o,5);//将原对象写入，如果有参数就写在后面
        Object getState = getGetState.invoke(o);
        System.out.println(getAge+" "+getState);
        System.out.println("---------------");
    }
}
class Car{
    int age;
    private String name;
    static int state;
    public Car(){
    }
    private Car(int age){
        this.age = age;
    }
    public Car(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Car{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static int getState() {
        return state;
    }

    public void setState(int state) {
        Car.state = state;
    }

}