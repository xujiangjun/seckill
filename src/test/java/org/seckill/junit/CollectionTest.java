package org.seckill.junit;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.seckill.entity.Person;

import java.util.*;

/**
 * User: xujiangjun
 * Date: 16/9/8 12:31
 */
public class CollectionTest {

    @Test
    public void listForNullPointerTest(){
        List<String> list = null;
        try {
            for (String str : list){
                System.out.println("Hello " + str);
            }
        } catch (NullPointerException e){
            // 将会抛出异常，并打印这句话
            System.out.println("happen NullPointer Exception!");
        }
    }

    @Test
    public void testRemoveAll(){
        List<String> str1List = Lists.newArrayList("a","b","c", "d");
        List<String> str2List = Lists.newArrayList("b","c", "e");
        str1List.retainAll(str2List);
        System.out.println("str1List将只保留与str2List共有的元素，即保留b和c");
    }

    /**
     * EmptyList进行for循环不会抛出异常
     */
    @Test
    public void emptyListForeachTest(){
        List<String> list = new ArrayList<String>();
        for (String str : list){
            System.out.println("Hello " + str );
        }
    }

    @Test
    public void indexOfTest(){
        List<String> strList = Lists.newArrayList("Hel", "lun", "base");
        System.out.println(strList.indexOf("lun"));
    }

    @Test
    public void collectionSortTest(){
        List<Integer> list = Lists.newArrayList(4,6,1,5);
        Collections.sort(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }

    @Test
    public void cTest(){
        Set<Person> set = new HashSet<>();
        Person p1 = new Person();
        p1.setName("zhang");
        Person p2 = new Person();
        p2.setName("zhang");
        set.add(p1);
        set.add(p2);
        System.out.println(set);
    }

    @Test
    public void lTest(){
        List<Person> list = new ArrayList<>();
        Person p1 = new Person();
        p1.setName("zhang");
        Person p2 = new Person();
        p2.setName("zhang");
        list.add(p1);
        System.out.println(list.contains(p2));
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() { // 断点0
            @Override
            public void run() {
                System.out.println("1"); // 断点1
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("2"); // 断点2
            }
        }).start();
        // 外线程
        System.out.println("3"); // 断点3
        Thread.sleep(2000);
        System.out.println("4"); // 断点4
    }
}
