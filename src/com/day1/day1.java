package com.day1;

public class day1 { //只有一个public类，且类名与文件名一致
    public static void main(String[] args) { //此方法在任何类不唯一
        ;
        int a = 10;
        String x = a + " ";// String converse int needing add " "；
        System.out.println(x);
        String y = "123";
        int num1 = Integer.parseInt(y);
        float num2 = Float.parseFloat(y);
        byte num3 = Byte.parseByte(y);
        boolean num4 = Boolean.getBoolean(y);
        System.out.println(num1+" "+num2+" "+num3+" "+num4);
        System.out.println(y.charAt(0));//String转为char类型

        int numa = 10;
        int numb = numa; // 值传递；
        numb = 20;
        System.out.println(numa+""+numb); //10 20;

        int[] numc = {1,2,3};
        int[] numd = numc;//地址传递
        numd [0] = 10;
        System.out.println(numc[0] + "" +numd[0]);// 10 10;

    }

}
class tiger{ //只要创建类，就会有新的类文件出现
    public static void main(String[] args) {
    }
}