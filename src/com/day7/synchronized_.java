package com.day7;

public class synchronized_ {
    public static void main(String[] args) {
        AA aa1 = new AA();
        aa1.start();
        AA aa2 = new AA();
        aa2.start();
        AA aa3 = new AA();
        aa3.start();
//        BB bb = new BB();
//        new Thread(bb).start();
//        new Thread(bb).start();
//        new Thread(bb).start();

    }
}
class AA extends Thread{
    boolean flag = true;
    int count = 100;
    public synchronized void sell(){
        if(count == 0){
            System.out.println("票卖完了");
            flag = false;
            return;
        }
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(currentThread().getName()+" 的票在卖 "+--count);
    }

    @Override
    public void run() {
        while (flag) {
            sell();
        }
    }
}
class BB implements Runnable{
    int count = 100;
    boolean flag = true;
    public void sell(){
        synchronized (this){
            if(count <= 0){
                System.out.println("票卖完了");
                flag = false;
                return;
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+" 的票在卖 "+--count);
        }
    }
    @Override
    public void run() {
        while (flag){
            sell();
        }
    }
}