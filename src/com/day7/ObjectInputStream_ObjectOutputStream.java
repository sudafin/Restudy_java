package com.day7;

import java.io.*;

public class ObjectInputStream_ObjectOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream_ObjectOutputStream objectInputStreamObjectOutputStream = new ObjectInputStream_ObjectOutputStream();
        objectInputStreamObjectOutputStream.ObjectOutputStream_();
        objectInputStreamObjectOutputStream.ObjectInputStream_();
    }
    public void ObjectOutputStream_() throws IOException {
        String pathName = "src\\com\\day7\\source\\data.dat";
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(pathName));
        objectOutputStream.writeInt(100);
        objectOutputStream.writeBoolean(true);
        objectOutputStream.writeDouble(16.6);
        objectOutputStream.writeUTF("争议");//输入String
        objectOutputStream.writeObject(new Dog(18,"小东西",7,"boy"));
        objectOutputStream.close();
    }
    public void ObjectInputStream_() throws IOException, ClassNotFoundException {
        String pathName = "src\\com\\day7\\source\\data.dat";
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(pathName));
        objectInputStream.readInt();
        objectInputStream.readBoolean();
        objectInputStream.readDouble();
        objectInputStream.readUTF();
        Object o = objectInputStream.readObject();
        Dog o1 =(Dog)o;
        System.out.println(o);
        System.out.println(o1.getAge());
        System.out.println(o1.getVoice());
        System.out.println(o1.name);
        System.out.println(o.getClass());
        objectInputStream.close();
    }
}
