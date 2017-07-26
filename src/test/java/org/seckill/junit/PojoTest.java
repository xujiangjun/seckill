package org.seckill.junit;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.seckill.entity.Person;
import org.seckill.entity.Professional;
import org.seckill.entity.Student;
import org.springframework.beans.BeanUtils;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.*;

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
        Map<Integer, Integer> map = Maps.newHashMap();
        map.put(1, null);
        map.put(2, null);
        System.out.println(map);
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

    @Test
    public void testStringReplace(){
        String str = "aaabbaaa";
        System.out.println(str.replace('a', 'c'));
        System.out.println(Integer.highestOneBit(6));
        Scanner scanner = new Scanner(System.in).useDelimiter(",");
    }

    @Test
    public void testCompare(){
        List<String> strList = Lists.newArrayList("H01-02", "HH1-01", "H02-01", "A01-01");
        Collections.sort(strList);
        System.out.println(strList);
    }

    @Test
    public void testHello(){
        StringBuilder s = new StringBuilder("my ");
        he(s);
        System.out.println(s.toString());
        int i =2;
        i /= 3-2;
        System.out.println(i);
    }
    private static final Random RANDOM = new Random();

    private void he(StringBuilder s){
        s.append("he");
    }

    @Test
    public void t() throws NoSuchFieldException, IllegalAccessException {
        Integer a = 129;
        Integer b = 258;
        System.out.println(a + ":" + b);
        swap(a, b);
        System.out.println(a + ":" + b);
    }

    private void swap(Integer a, Integer b) throws NoSuchFieldException, IllegalAccessException {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        int aValue = (int) field.get(a);
        int bValue = (int) field.get(b);
        field.set(a, bValue);
        field.set(b, aValue);
    }
}
