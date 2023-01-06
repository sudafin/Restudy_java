package com.day4;

import com.sun.source.tree.Tree;

import java.util.*;
@SuppressWarnings({"all"})
public class Collection_Set {
    public static void main(String[] args) {
        Set set1 = new HashSet();
        Set set2 = new TreeSet();
        Set set3 = new LinkedHashSet();
        Set_(set3);
        System.out.println(Collections.max(set3));
    }
    public static void Set_(Set set){
        set.add(8);
        set.add(4);
        set.add("b");
        set.add("a");
        for (Object o:
                set) {
            System.out.println(o);
        }
        System.out.println("打印完了");
    }
}
