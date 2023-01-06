package com.day7;

import java.util.Scanner;

public class Thread_Runnable {
    public static void main(String[] args) {
        Thread_ thread = new Thread_("1");
        thread.start();
        Thread_ thread1 = new Thread_("2");
        thread1.start();
//        Runnable_ runnable = new Runnable_();
//        Thread thread1 = new Thread(runnable);
//        thread1.start();
    }
}
class Thread_ extends Thread{
    int count = 50;
    public Thread_(String name){
        System.out.println(name);
    }
//    @Override
//    public void run() {
//        while (count!=0){
//            System.out.println("hello"+Thread.currentThread().getName()+ (--count));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }
    public void run(){
        while (true) {
            get();
        }
    }
    public synchronized void get(){
        System.out.println(Thread_.currentThread().getName());
        Scanner sc= new Scanner(System.in);
        String next = sc.next();
        System.out.println(next);
    }
}
class Runnable_ implements Runnable{
    int count = 40;
    @Override
    public void run() {
        while (count!=0){
            System.out.println("hi"+Thread.currentThread().getName()+ (--count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}