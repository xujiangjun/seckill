package org.seckill.junit;

import com.google.common.base.*;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
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

    @Test
    public void OptionalTest(){
        //Optional.of(null);
        //Optional.of(null).or("5");
        System.out.println(Optional.fromNullable(null).or("5"));
        System.out.println(Optional.of(10).asSet());
    }

    @Test
    public void ImmutableSetTest(){
        Set<String> stringSet = new HashSet<>(Arrays.asList("Hello", "Kite"));
        ImmutableSet immutableSet = ImmutableSet.copyOf(stringSet); // 防御性拷贝
        stringSet.add("Lucy");
        System.out.println(immutableSet);
        System.out.println(stringSet);
    }

    @Test
    public void FilesTest(){
        File file = new File("/Users/xujiangjun/Desktop/1-1-1_optimize_allocate_saint_ddl_20161024.sql");
        List<String> content = null;
        try {
            content = Files.readLines(file, Charsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for (String line : content) {
            System.out.println(line);
        }
    }

    @Test
    public void optionalTest(){
        System.out.println(Optional.fromNullable(null).or(10));
        long startTimeStamp = System.currentTimeMillis();
        System.out.println(1 << 29);
        System.out.println(System.currentTimeMillis() - startTimeStamp);
        long startTime = System.currentTimeMillis();
        System.out.println(Math.pow(2,29));
        System.out.println(System.currentTimeMillis() - startTime);
    }

    @Test
    public void testFormat(){
        List<Integer> arrList = Lists.newArrayList(4, 3, 2, 1);
        System.out.println(Ordering.natural().reverse().isOrdered(arrList));
        System.out.println(MoreObjects.toStringHelper("Hello").add("x", 10).add("y", 20).toString());
        Preconditions.checkArgument(1>2, "%s%s", "It", "is", "false", "true");
        Integer a = Optional.<Integer>fromNullable(null).or(10);
        System.out.println(a);
    }

    /**
     * 泛型通配符只读性：只能读，不能写
     * @param list  未知类型的list
     */
    public void GenericTest(List<?> list){
        new ThreadLocal<String>(){
            @Override
            protected String initialValue() {
                return super.initialValue();
            }
        };
        //list.set(0, "Hello");
    }

    public static void main(String[] args) {
        List<Integer> arrList = Lists.newArrayList(4, 3, 2, 1);
        Iterator<Integer> it = arrList.iterator();
        while (it.hasNext()){
            it.next();
            it.remove();
        }
        System.out.println(arrList.size());
    }

    @Test
    public void testSpittle(){
        Map<String, String> tokenMap = Splitter.on(",").withKeyValueSeparator(":").split("1:2");

    }

    @Test
    public void testS(){
        String str = "b68807af-ae43-453b-ab14-33156b76baf7.jpgb68807af-ae43-453b-ab14-33156b76baf7.jpg";
        Iterable<String> it = Splitter.on(".jpg").omitEmptyStrings().trimResults().split(str);
        for (String s : it) {
            System.out.println(s);
        }
    }

}
