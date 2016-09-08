package org.seckill.junit;

import com.google.common.base.*;
import com.google.common.base.Objects;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.*;

/**
 * User: xujiangjun
 * Date: 16/9/8 12:31
 */
public class GuavaTest {

    /**
     * on(",")                          ->  按","（逗号）将str进行分离
     * omitEmptyStrings()               ->  去除空的字符串
     * trimResults                      ->  去除空格
     * trimResults(CharMatcher.DIGIT)   ->  去除数字
     * split(str)                       ->  str为需要进行操作的字符串
     */
    @Test
    public void SplitterTest1(){
        String str = "a,,b,     c3,,,d";
        Iterable<String> it = Splitter.on(",").omitEmptyStrings()
                .trimResults(CharMatcher.DIGIT).trimResults().split(str);
        for (String s : it) {
            System.out.println(s);
        }
        //下面的语句与上面的执行起来有区别，trimResults()方法没起作用
        Iterable<String> iter = Splitter.on(",").omitEmptyStrings().trimResults()
                .trimResults(CharMatcher.DIGIT).split(str);
        for(String s : iter){
            System.out.println(s);
        }
    }

    /**
     * withKeyValueSeparator(":")    -> 以","（逗号）进行分隔得到一组数据后，使用":"（冒号）得到一组entry
     */
    @Test
    public void SplitterTest2(){
        String str = "a:12,,b:23,     c3:24";
        Map<String,String> map = Splitter.on(",").omitEmptyStrings().trimResults()
                .withKeyValueSeparator(":").split(str);
        for(Map.Entry<String, String> entry : map.entrySet()){
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    @Test
    public void JoinerTest1(){
        Map<String, String> map = new HashMap<String, String>();
        map.put("tqmall", "淘汽档口");
        map.put("xujiangjun", "徐蒋军");
        String str = Joiner.on(",").withKeyValueSeparator(":").join(map);
        System.out.println(str);
    }

    @Test
    public void JoinerTest2(){
        //String[] str = new String[]{};
        String[] str = new String[]{"1", "2", null, "3"};
        List<String> list = Arrays.asList(str);
        String concatStr = Joiner.on(",").skipNulls().join(list);
        System.out.println(concatStr);
    }

    @Test
    public void JoinerTest3(){
        List<String> list = new ArrayList<String>();
        list.add("tqmall");
        list.add("xujiangjun");
        String concatStr = Joiner.on(",").join(list);
        System.out.println(concatStr);
    }

    @Test
    public void ObjectsTest(){
        System.out.println(Objects.equal(null, "a"));
        System.out.println(ComparisonChain.start().compare(10, 10).compare(12, null,
                Ordering.natural().nullsFirst()).compare("abe", "abd").result());
    }

    @Test
    public void StringsTest(){
        String a = "com.jd.coo.Hello";
        String b = "com.jd.coo.Di";
        String ourCommonPrefix = Strings.commonPrefix(a,b);
        System.out.println("a,b common prefix is " + ourCommonPrefix);
    }

    @Test
    public void listInitialTest(){
        List<Integer> ids = Lists.newArrayList(745303, 745321, 745026, 744891, 745283, 745276);
        Integer id = 745276;
        if(ids.contains(id)){ //即时是包装器类型使用contains返回的也算true
            System.out.println(true);
        }
    }
}
