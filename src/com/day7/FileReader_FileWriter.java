package com.day7;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReader_FileWriter {
    public static void main(String[] args) throws IOException {
        FileReader_FileWriter fileReaderFileWriter = new FileReader_FileWriter();
        fileReaderFileWriter.FileWriter_();
        fileReaderFileWriter.FileReader_();
    }
    public void FileWriter_() throws IOException {
        String pathName = "src\\com\\day7\\testText1.text";
        FileWriter fileWriter = new FileWriter(pathName);
        fileWriter.write("可以");
        fileWriter.write("运行文件",0,4);//off表示从哪个文字开始，len表示输入几个文字
        System.out.println("创建成功");
        fileWriter.close();
    }
    public void FileReader_() throws IOException{
        String pathName = "src\\com\\day7\\testText1.text";
        FileReader fileReader = new FileReader(pathName);
        int len = 0;
        char[] chars = new char[8];
        while ((len = fileReader.read(chars))!= -1){
            System.out.println(new String(chars,0,len));
        }
        fileReader.close();
    }
}