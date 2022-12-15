package com.day7;
import java.io.*;
import java.util.Arrays;

public class InputStreamReader_OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        InputStreamReader_OutputStreamWriter inputStreamReaderOutputStreamWriter = new InputStreamReader_OutputStreamWriter();
        inputStreamReaderOutputStreamWriter.OutputStreamWriter();
        inputStreamReaderOutputStreamWriter.InputStreamReader();
    }
    public void OutputStreamWriter()throws IOException{
        String pathName = "src\\com\\day7\\source\\testText4.text";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(pathName),"gbk");
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("不好");
        outputStreamWriter.write("加油中文");
        bufferedWriter.close();
    }
    public void InputStreamReader() throws IOException{
        String pathName = "src\\com\\day7\\source\\testText4.text";
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(pathName),"gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        //第一种
        String s = bufferedReader.readLine();
        System.out.println(s+"00");
        //第二种
        int read =0 ;
        char[] chars = new char[1024];
        while ((read =inputStreamReader.read(chars))!= -1) {
            System.out.println(new String(chars,0,read)+"ee");
        }
    }
}
