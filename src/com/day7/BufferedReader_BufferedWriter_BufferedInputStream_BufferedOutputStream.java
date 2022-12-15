package com.day7;

import java.io.*;
import java.nio.Buffer;

public class BufferedReader_BufferedWriter_BufferedInputStream_BufferedOutputStream {
    public static void main(String[] args)throws IOException {
        BufferedReader_BufferedWriter_BufferedInputStream_BufferedOutputStream bufferedReaderBufferedWriterBufferedInputStreamBufferedOutputStream = new BufferedReader_BufferedWriter_BufferedInputStream_BufferedOutputStream();
        bufferedReaderBufferedWriterBufferedInputStreamBufferedOutputStream.BufferedWriter_();
        bufferedReaderBufferedWriterBufferedInputStreamBufferedOutputStream.BufferedReader_();
        bufferedReaderBufferedWriterBufferedInputStreamBufferedOutputStream.CopyVideo_In_BufferedInputStream_BufferedOutStream();
    }
    public void BufferedWriter_() throws IOException {
        String pathName = "src\\com\\day7\\source\\testText3.text";
        BufferedWriter buffer = new BufferedWriter(new FileWriter(pathName));
        buffer.write("经济一百年");
        buffer.newLine();//打印换行
        buffer.write("可以");
        buffer.close();
    }
    public void BufferedReader_() throws IOException{
        String pathName = "src\\com\\day7\\source\\testText3.text";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathName));
        String s = "";
        while ((s = bufferedReader.readLine())!=null){
            System.out.println(s);
        }
        bufferedReader.close();
    }
    public void CopyVideo_In_BufferedInputStream_BufferedOutStream()throws IOException{
        String sourPathName = "src\\com\\day7\\source\\test.mp4";
        String destPathName = "src\\com\\day7\\source\\test1.mp4";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(sourPathName));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(destPathName));
        //第一种
//        int len = 0;
//        byte[] bytes = new byte[1024];
//        while ((len = bufferedInputStream.read(bytes)) != -1){
//            bufferedOutputStream.write(len);
//        }
        //第二种
        byte[] bytes = bufferedInputStream.readAllBytes();
        bufferedOutputStream.write(bytes);
        System.out.println("拷贝成功");
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
