package com.day7;

import java.io.File;
import java.io.*;

public class FileInputStream_FileOutputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream_FileOutputStream fileInputStreamFileOutputStream = new FileInputStream_FileOutputStream();
        fileInputStreamFileOutputStream.FileOutputStream_();
        fileInputStreamFileOutputStream.FileInputStream_();
        fileInputStreamFileOutputStream.CopyImg();//复制图片
    }
    public void FileOutputStream_() throws IOException {//程序-文件
        String pathName = "src\\com\\day7\\source\\testText.text";
        FileOutputStream fileoutputStream = new FileOutputStream(pathName);//自动创建文件不需要手动创建
        //如果在pathName后追加true，就可以在源文件下追加文字
        String str = "hello,world";
        fileoutputStream.write(str.getBytes(),0,str.length());
        System.out.println("文件写入创建成功");
        fileoutputStream.close();
    }
    public void FileInputStream_ () throws IOException{//文件-程序
        String pathName = "src\\com\\day7\\source\\testText.text";
        FileInputStream fileInputStream = new FileInputStream(pathName); //需要要源文件

        int len = 0;
        byte [] bytes = new byte[8];
        while ((len = fileInputStream.read(bytes))!= -1){
            System.out.print(new String(bytes,0,len));
        }
        fileInputStream.close();
    }
    public void CopyImg() throws IOException{
        String pathName = "src\\com\\day7\\source\\test_img.png";
        FileInputStream fileInputStream = new FileInputStream(pathName);//源
        FileOutputStream fileOutputStream = new FileOutputStream("src\\com\\day7\\source\\test_img1.png");//输入文件
        int len = 0;
        byte []bytes = new byte[1024];
        while ((len = fileInputStream.read(bytes))!= -1){
            fileOutputStream.write(bytes,0,len);
        }
        System.out.println("拷贝成功");
        fileInputStream.close();
        fileOutputStream.close();
    }
}
