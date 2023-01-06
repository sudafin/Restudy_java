package com.day4;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@SuppressWarnings({"all"})
public class Collection_List {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        List list2 = new ArrayList();
        //add(int index,Object obj);指定的位置添加元素,或者直接添加，不能越过index序列号
        list1.add(0,"0的位置");
        list1.add(1,"1的位置");
        Iterate(list1);
        //addAll(int index，List else);指定的位置将其他List添加进去，如果其他list有多个数，按顺序插进去
        list2.addAll(0,list1);
        list2.add(2,"2的位置");
        Iterate(list2);//打印结果：0的位置 2 2的位置
        //get(int index),获取指定索引的值
        Object o = list1.get(0);
        //indexOf(object obj)返回 相同 obj的第一个的位置,返回-1就是不存在，
        //lastIndexOf(Object obj)返回 相同 obj的最后一个的位置，返回-1就是不存在
        System.out.println(list2.indexOf("1的位置"));
        //remove(int index)删除的指定值
        //set(int index,Object else)将指定的位置的值替换成else
        //List subList(int fromIndex,int toIndex)返回一个从指定初位置到末位置中的值的集合 (n<=value<m)
        List list3 = list2.subList(0, 2);
        Iterate(list3);//0的位置  1的位置
    }
    public static void Iterate(List list){ //遍历方法·
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("打印完了");
    }
}