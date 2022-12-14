package com.day5;


public class TestTemple {
    public static void main(String[] args) {
        new AA().calculateTime();
        new BB().calculateTime();
    }
}

abstract class Temple{
    public abstract void job();
    public void calculateTime(){
        long start = System.currentTimeMillis();
        job();
        long end = System.currentTimeMillis();
        System.out.println("时间是（ms）"+ (end - start));
    }
}
class AA extends Temple{
    @Override
    public void job() {
        int num = 0;
        for(int i = 0;i < 1000000;i++){
            num += i;
        }
    }
}
class BB extends Temple{

    @Override
    public void job() {
        int num = 0;
        for(int i = 0;i < 8000000;i++){
            num += i;
        }
    }
}