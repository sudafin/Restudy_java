package com.day4;

import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.util.*;

@SuppressWarnings({"all"})
public class Map_Iterator {
    public static void main(String[] args)  {
        Map map = new HashMap();
        map.put("no1",1);
        map.put("no2",2);
        map.put("no3",3);
        map.put(null,null);
        map.put("no4",4);
        //KeySet,通过key找value
        Collection set = map.keySet();
        for (Object obj:set) {
            System.out.println(map.get(obj));
        }
        System.out.println("①----------------------");
        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(map.get(next));
        }
        System.out.println("①----------------------");
        //values，直接找到value
        Collection values = map.values();
        for (Object obj:
             values) {
            System.out.println(obj);
        }
        System.out.println("②----------------------");
        Iterator iterator1 = values.iterator();
        while (iterator1.hasNext()){
            Object next = iterator1.next();
            System.out.println(next);
        }
        System.out.println("②----------------------");
        //entrySet 通过获取每一对的关系，再通过另一个Map.Entry来得到这一对的关系，来向上转型，用getValue()方法来获取值，同样也可以获取key
        Set set1 = map.entrySet();
        for (Object obj:
             set1) {
            Map.Entry m = (Map.Entry)obj;//向上转型
            System.out.println(m.getValue());
        }
        System.out.println("③----------------------");
        Iterator iterator2 = set1.iterator();
        while (iterator2.hasNext()){
            Object next = iterator2.next();
            Map.Entry m = (Map.Entry)next;
            System.out.println(m.getValue());
        }
        System.out.println("③----------------------");
    }
}
