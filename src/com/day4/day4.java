package com.day4;

import java.util.ArrayList;
import java.util.Collections;

/**
    一、equals与==的区别：==表示的地址是否相同，equals表示的是引用是否相同
    二、static:同一个类的不同对象都可以调用，遵循修饰符的原则，public static int =1
       or public static void play()->不能用this;
    三、main：程序的入口，可以访问本类中的静态方法和变量，非静态则需要实例化本类（new）
    四、代码块：代码块执行顺序（普通的代码块先于静态的）先于构造器，是对构造器的补充,每创建一次对象都执行一次
       eg；[static]{              {
          System.out.println();    System.out.println();
          System.out.println();    System.out.println();
          System.out.println();    System.out.println();
          }                       }
       ①、类的加载而加载：a、创建对象加载；b、创建子类对象实例，父类也会加载；c、使用类的静态方法（静态属性、静态方法）
         普通的代码块，在创建对象时会被隐式被调用，被创建一次就被调用一次，如果只是调用类的静态成员，普通代码并不会执行
       ②、构造器隐含 super（）（父类的构造器） 和 本类的代码块
    五、饿汉式和懒汉式：private下的构造器，饿汉式用static new了本类，而懒汉式则不用static，两者都需要用一个方法去返回值
    六、final：使用情况，a、不希望被继承；b、不希望父类的某个方法被子类覆盖和重写；c、不希望值被改变；
                      d、final被定义后，不能在构造器赋初值，但能在代码块初值，且不能修饰构造器
                      e、final类不能被继承，但能被实例，但如果不是final类但是final方法，可以继承不能重写
    七、集合：分为单例，和双例集合，前者为实现List，Set接口，后者实现Map接口；
           单例集合：List是有序的，Set是无序的；
           双例集合：a、Map的key不允许重复，value允许重复；b、key可以为null，但只能为一个，value的null是不限的；
                   c、String类型也可以是key；d、key和value是一一对应的关系
        ①、单例集合Collection的实现方法：add(添加单个元素),remove(删除指定元素),contains(查找元素是否存在),size(获取元素的个数),isEmpty(判断是否为空),
                           clear(清空),addAll(添加多个元素),containsAll(查找多个元素是否与其他集合相同),removeAll(删除多个元素)
            双例集合Map的实现方法：put(添加key和value),remove(根据key去掉value),get(根据key得到value),size(得到个数),isEmpty(是否为空),
                               clear(清除集合),containsKey(查找key是否存在),entrySet(获取所有的关系),keySet(获取所有的键),values(获取所有的值)
        ②、遍历方式：
            单例集合:
                   因为实现了Iterator接口，所以可以使用迭代器循环；
                  （使用方法，Iterator<Object> iterator = i.Iterator(); iterator<Object>.hasNext()->判断是否还有数据;Object obj =iterator.next->返回的是存放值）
                   Set无法用for方法，只能使用foreach和迭代器，原因是因为没有索引; 其他的都能用for和foreach和迭代器；
            双例集合：
                    用entrySet(),KeySet(),values();这三种方法分别用foreach和迭代器
                    (因为key是Set方法--本质也是Collection、value是Collection所以可以使用迭代器)循环，总共六种
                    Map_Iterator;
        ③、List：
           a：List集合类中元素是有序的（既添加顺序和取出顺序是一致的），且可重复； b:List集合中的每个元素都有其对应的顺序索引，即支持索引（0 - n-1）；
           c、List的实现方法Collection_List； d：可以添加多个null；底层使用数组；
           e、ArrayList：扩容倍数——如果有参构造1.5倍，如果无参第一次10，第二次开始1.5扩；线程不安全，对比Vector效率；（数组）
           f、Vector：扩容倍数——如果是无参，默认10，满后，按2倍扩容，如果指定大小则每次按2倍扩；线程安全，对比ArrayList效率低；（数组）
           g、LinkedList：对比ArrayList增删较高，改查较低,线程不安全；（双向链表）
           h、Collection_List
        ④、Set：
          a、都不能存放重复元素；
             TreeSet的取出是随机的（这个随机是按顺序排），只能存放数字，不能存放字母和null；
             HashSet的取出是随机的（这个随机是按顺序排），能存放一个null，能存放各种；
             LinkedHashSet存放和取出是相同的，能存放各种；
          b、HashSet：底层用HashMap（哈希表）；LinkedHashSet：底层用LinkedHashMap（双向链表）；TreeSet：底层用HashMap（红黑树）
          c、Collection_Set;
        ⑤、Map:
          a、HashMap是线程不安全的；HashTable是线程安全的（key和value不能为value），使用方法与HashMap一样
          b、当有相同的key不同的value时，会被替换；
          c、键无序：HashMap（哈希表，数组+链表+红黑树）；  键有序：TreeMap； 键插入和取出顺序一致：LinkedHashMap
             读取文件：Properties；
        ⑥、Collections工具类:
           reverse(List)：反转List元素的顺序；       shuffle(List)：对List集合中元素进行随机排序；
           sort(list)：根据元素的自然顺序对List集合中的元素进行升序和降序的处理；
           sort(List,Comparator)：根据对指定的Comparator产生的顺序对List集合排序；
           swap(List,int i,int j)：对list中的指定i和j的位置进行对换
           max/min(List)：返回同种类型的最大/小值；    max/min(List,Comparator)：根据Comparator的顺序返回最大/小值
           frequency(Collection,Object)：返回指定集合中指定元素出现的次数；copy(List dest,List src)：将src的内容复制到src
           replaceALl(List list,Object oldVal,Object newVal)：使用新值去替换旧值
    八、泛型
       ①、使用方法：List<Integer> list = new List<Integer>();
               List<Integer> list = new List<>();
       ②、在传入类型时，如果该类型是其子类型也可以传进去
       ③、自定义泛型
         类：Class 类名<T,R....>
            a、普通成员可以使用泛型（属性，方法） b、使用泛型的数组，不能初始化； c、静态方法中不能使用类的泛型；
            c、泛型类的类型，是在创建对象时确定的；  d、如果在创建对象时，没有指定类型，默认为Object；
         接口：a、接口中，静态成员不能使用泛型； b、泛型接口的类型，在继承接口或者实现接口时确定；
              c、没有指定类型，默认为Object；
         方法：修饰符 <T,R....> 返回类型 方法名(参数列表){}
              a、泛型方法可以定义在普通类中，也可以定义在泛型类中； b、当泛型方法被调用时，类型会被确定；
              c、public void 方法名(E e){} 返回类型后面不是<T,R....>的方法，是使用了泛型；
       ④、a：泛型不具备继承性;  b：List<?>表示任意泛型类型都可以接收；
          c、List<? extends AA> ：表示支持AA和继承了AA的子类可以用的泛型
          d、List<? super AA>：表示支持AA和AA的父类可以使用的泛型
       ⑤、JUnit：可以加入@Test在某方法之上，可以独立于main方法允许（不用在main方法中new一个类再允许某方法）
 */
public class day4 {
    public static void main(String[] args) {
        reQuals();//equals重写
    }
    public static void reQuals(){
        Person p1 = new Person("mike",20);
        Person p2 = new Person("mike",20);
        Person p3 = new Person("mike",30);
        System.out.println(p1.equals(p2)); //true
        System.out.println(p1.equals(p3)); //false
    }
}
class Person{
    private String name;
    private int age;
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj instanceof Person){
            Person p = (Person)obj;
            return this.name.equals(p.name)&&this.age==p.age;
        }
        return false;
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
