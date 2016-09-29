package org.seckill.junit;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.junit.Test;
import org.seckill.entity.Person;
import org.seckill.entity.Student;
import org.springframework.beans.BeanUtils;

import java.sql.Timestamp;
import java.util.*;

/**
 * User: xujiangjun
 * Date: 16/9/8 12:45
 * BeanUtils.copyProperties(src, target)，其中如果src与target中字段名一致，类型不一致，则不能copy到
 */
public class UtilsTest {

    /**
     * true || false && false   表达式将先计算false && false部分,相当于 true || (false && false)
     */
    @Test
    public void logicTest(){
        System.out.println(true || false && false);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(System.currentTimeMillis()/1000);
        System.out.println(Integer.valueOf(String.valueOf(1470035134)));
    }

    @Test
    public void GosnTest(){
        Gson gson = new Gson();
        Long[] longs = {123l, 1245l};
        System.out.println(longs);
        System.out.println(new Gson().toJson(longs));
        Map<String, String> map = Maps.newHashMap();
        map.put("tqmall", "淘汽档口");
        map.put("xujiangjun", "徐蒋军");
        System.out.println(map);
        System.out.println(gson.toJson(map));

    }

    /**
     * 使用Collections.sort()对集合进行排序
     * 如果a > b 返回1(arg1 a, arg2 b)，代表默认按升序排序
     */
    @Test
    public void sortTest(){
        List<Person> list = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setAge(20);
        p1.setName("zhang");
        list.add(p1);
        Person p2 = new Person();
        p2.setAge(18);
        p2.setName("wang");
        list.add(p2);
        System.out.println(list);
        Collections.sort(list, new Comparator<Person>() {
            public int compare(Person obj1, Person obj2) {
                if(obj1.getAge() > obj2.getAge()){
                    return 1; // a.compare(b):若a > b , 返回 1, 此处返回1代表默认按age字段的升序排序
                }else if(obj1.getAge() == obj2.getAge()){
                    return 0;
                }
                return -1;
            }
        });
        System.out.println(list);
    }

    @Test
    public void jodaTimeTest1(){
        DateTime dateTime = new DateTime();
        System.out.println(dateTime.monthOfYear().getAsString());
        System.out.println(dateTime.monthOfYear().getAsText());
        dateTime = dateTime.withYear(2017);
        System.out.println(dateTime.year().isLeap());
        System.out.println(new DateTime(2012,11,20,12,30).toString());
        LocalDate start = new LocalDate(2012,11,20);
        LocalDate end = new LocalDate(2012,11,21);
        System.out.println(Days.daysBetween(start, end).getDays());
    }

    @Test
    public void jodaTimeTest2(){
        DateTime dateTime = new DateTime(2012,3,31,12,30);
        DateTime dt = dateTime.plusMonths(1).minusDays(1);
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(Math.round(Math.random() * 9998 + 90001));
    }

    /**
     * DateTime与String一样，是一个final class，所以值不会被改变
     */
    @Test
    public void jodaTimeTest3(){
        DateTime dateTime = new DateTime();
        String endDelayTime = dateTime.toString("yyyy-MM-dd HH:mm:ss");
        String startDelayTime1 = dateTime.minusDays(2).toString("yyyy-MM-dd HH:mm:ss");
        String startDelayTime2 = dateTime.minusDays(2).toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(startDelayTime1 + "==" + startDelayTime2 + "==" + endDelayTime);
    }

    @Test
    public void jodaTimeTest4() {
        DateTime dateTime = new DateTime(2015,3,3,0,0,0);
        System.out.println(dateTime.getHourOfDay());
        DateTime dt = dateTime.withHourOfDay(10);
        System.out.println(dateTime.toDate().getTime());
        System.out.println(dateTime.toInstant().getMillis());
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss E"));
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss EE"));
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss EEE"));
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss EEEE"));
    }

    @Test
    public void timestampTest() {
        String startTime = "2016-09-10 12:30:50";
        System.out.println(Timestamp.valueOf(startTime).getTime());
    }

    @Test
    public void beansCopyTest(){
        Student stu = new Student();
        stu.setBooksNames(Lists.newArrayList("Spring in Action","Spring docs"));
        Student stuCopy = new Student();
        BeanUtils.copyProperties(stu, stuCopy);
        System.out.println(stuCopy);
    }
}
