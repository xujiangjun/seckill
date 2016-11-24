package org.seckill.junit;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * User: xujiangjun
 * Date: 16/9/8 12:31
 */
public class CollectionTest {

    /**
     * 将抛出空指针异常
     */
    @Test
    public void listForNullPointerTest(){
        List<String> list = null;
        try {
            for (String str : list){
                System.out.println("Hello " + str);
            }
        } catch (NullPointerException e){
            System.out.println("NullPointer Exception!");
        }
    }

    @Test
    public void testRemoveAll(){
        List<String> str1List = Lists.newArrayList("a","b","c", "d");
        List<String> str2List = Lists.newArrayList("b","c", "e");
        str1List.retainAll(str2List);
        System.out.println("T");
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
}
