package org.seckill.junit;

import org.junit.Test;
import org.seckill.entity.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * User: xujiangjun
 * Date: 16/9/8 12:32
 */
public class PojoTest {

    /**
     * 对同一个对象操作（同一个内存地址操作，改变已有的值）
     * 结果：将打印两条一样的Person
     */
    @Test
    public void sameObjOperationTest(){
        List<Person> persons = new ArrayList<Person>();
        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(24);
        persons.add(person);
        //对同一个对象操作，然后add到list中
        person.setName("lisi");
        person.setAge(25);
        persons.add(person);
        System.out.println("测试对同一个对象操作：" + persons);
    }

    @Test
    public void nullObjPrintTest(){
        Person person = null;
        System.out.println(person);
    }

    @Test
    public void Long2IntTest(){
        Long id = -1l; //必须使用l标识long
        System.out.println(id.intValue() == -1);
    }

    @Test
    public void IntegerEqualTest(){
        Integer a = new Integer(1);
        Integer b = new Integer(1);
        int c = 1;
        System.out.println(a == 1);
        System.out.println(a == b);
        System.out.println(a.equals(b));
        System.out.println(a == c);
    }
}
