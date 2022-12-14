package com.day6;

public class String_ {
    public static void main(String[] args) {

    }
}
class StringBuffer_{
    public static void main(String[] args) {
        //String - StringBuffer
        String s = "abc";
        StringBuffer s1 = new StringBuffer(s);
        StringBuffer s2 = new StringBuffer();
        s2 = s2.append(s);

        //StringBuffer - String
        StringBuffer s3 = new StringBuffer("abc");
        String s4 = s3.toString();
        String s5 = new String(s3);
    }
}