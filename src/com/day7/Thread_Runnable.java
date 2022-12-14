package com.day7;

public class Thread_Runnable {
    public static void main(String[] args) {
        Thread_ thread = new Thread_();
        thread.start();

        Runnable_ runnable = new Runnable_();
        Thread thread1 = new Thread(runnable);
        thread1.start();
    }
}
class Thread_ extends Thread{
    int count = 50;
    @Override
    public void run() {
        while (count!=0){
            System.out.println("hello"+Thread.currentThread().getName()+ (--count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
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