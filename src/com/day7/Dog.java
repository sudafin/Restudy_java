package com.day7;

import java.io.Serializable;

public class Dog implements Serializable {
    int age;
    String name;
    static String sex;
    transient int voice;

    public Dog(int age, String name, int voice,String sex) {
        this.age = age;
        this.name = name;
        this.voice = voice;
        Dog.sex = sex;
    }

    public static String getSex() {
        return sex;
    }

    public static void setSex(String sex) {
        Dog.sex = sex;
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", voice=" + voice +
                '}'+ sex;
    }
}
