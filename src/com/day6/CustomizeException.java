package com.day6;

public class CustomizeException {
    public static void main(String[] args) {
        int age = 17;
        if(!(age>=18&&age<=60)){
            throw new AgeException("年龄异常");
        }
        System.out.println("年龄正确");
    }
}
class AgeException extends RuntimeException{
    public AgeException(String name){
        super(name);
    }
}