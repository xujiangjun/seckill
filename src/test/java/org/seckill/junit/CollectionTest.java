package org.seckill.junit;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
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
}
