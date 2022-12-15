package com.day7;

import java.io.*;

public class PrintStream_PrintWriter {
    public static void main(String[] args) throws IOException {
        PrintStream_PrintWriter printStreamPrintWriter = new PrintStream_PrintWriter();
//        printStreamPrintWriter.PrintStream();
        printStreamPrintWriter.PrintWriter();
    }
    public void PrintStream()throws IOException{
        String pathName = "src\\com\\day7\\source\\testText2.text";
        PrintStream printStream = System.out; //返回值是PrintStream
        printStream.print("hello");//输出到屏幕
        PrintStream printStream1 = new PrintStream(new FileOutputStream(pathName));
        printStream1.print("helloPrintStream");
        PrintStream printStream2 = new PrintStream(pathName);//两者都可以输入到文件
        printStream2.print("llo");
        printStream1.close();
        printStream2.close();
        printStream.close();
    }
    public void PrintWriter()throws IOException{
        String pathName = "src\\com\\day7\\source\\testText2.text";
        PrintWriter printWriter = new PrintWriter(System.out);
        printWriter.print("你好");
        printWriter.close();//必须close不然不会输出
        PrintWriter printWriter1 = new PrintWriter(new FileWriter(pathName));
        printWriter1.print("你好中文");
        printWriter1.close();
    }
}
