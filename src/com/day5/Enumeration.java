package com.day5;

public class Enumeration {
    public static void main(String[] args) {
        System.out.println(festival.SPRING);
        System.out.println(festival.WINTER);
        System.out.println(festival.SPRING.ordinal());//它的序号，序号从0开始
    }
}
enum festival{
    WINTER("冬天","冷"),SPRING("春天","温暖");
    private String name;
    private String character;
    private festival(String name,String character){
    this.name = name;
    this.character = character;
    }

    public String getName() {
        return name;
    }

    public String getCharacter() {
        return character;
    }

    @Override
    public String toString() { //重写tostring
        return name + "\t"+ character;
    }
}