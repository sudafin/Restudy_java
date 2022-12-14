package com.day5;

public class TestInterface {
    public static void main(String[] args) {
        microPhone microphone= new microPhone();
        Camera camera = new Camera();
        Computer computer = new Computer();
        computer.ToInter(microphone);
        computer.ToInter(camera);
    }
}

interface Function{
    void start();
    void stop();
}

class microPhone implements Function{
    @Override
    public void start() {
        System.out.println("The microphone is start");
    }

    @Override
    public void stop() {
        System.out.println("The microphone is stop");
    }
}
class Camera implements Function{
    @Override
    public void start() {
        System.out.println("The camera is start");
    }

    @Override
    public void stop() {
        System.out.println("The camera is stop");
    }
}
class Computer{
    public void ToInter(Function function){
        function.start();
        function.stop();
    }
}