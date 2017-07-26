package org.seckill.junit;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.Console;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.*;

/**
 * User: xujiangjun
 * Date: 16/9/8 13:07
 */
@Slf4j
public class NormalTest {

    /**
     * 将抛出空指针异常
     */
    @Test
    public void IntergerParseTest(){
        Integer.parseInt(null);
    }

    @Test
    public void systemProperyTest(){
        System.out.println(System.getProperty("user.timezone"));
    }

    /**
     * 随机数测试
     * 参考文献：http://gold.xitu.io/post/580f6a31c4c9710058a33221
     */
    @Test
    public void randomTest(){
        Random random = new Random(10000l);
        for (int i = 0; i < 10; i++) {
            System.out.print(random.nextInt(100) + " ");
        }
        System.out.println();
        char[] chars = new char[8];
        System.out.println(chars[0] + " " + chars[1] + " " + chars.length);

        System.out.println(5 >> 1);
    }

    @Test
    public void logTest(){
        long i = 10L;
        System.out.println(NumberFormat.getIntegerInstance().format(10.46f));
        log.error("Test:{}{}", "错误日志打印格式", "500");
        log.error("Test:{}{}", "错误日志打印格式", "500", new RuntimeException("抛出异常"));
    }

    @Test
    public void bigDecimalTest(){
        // MathContext构造函数第一个参数代表保留的有效位数，包含整数位数
        MathContext mc = new MathContext(4, RoundingMode.HALF_UP);
        BigDecimal a1 = new BigDecimal(10.12);
        BigDecimal a2 = new BigDecimal(10.0);
        BigDecimal a3 = new BigDecimal(15.216, mc);
        System.out.println(a3);
        System.out.println(a1.multiply(a3).divide(a2,2 , BigDecimal.ROUND_HALF_UP));
        BigDecimal a4 = BigDecimal.valueOf(1000000000).multiply(BigDecimal.valueOf(1, 9));
        System.out.println(a4);
    }

    @Test
    public void mathTest(){
        System.out.println(Math.random());
//        System.out.println(Byte.toUnsignedInt((byte)254));
        System.out.println(new Random().nextInt());
        System.out.println(Math.min(3, -2));
//        System.out.println(Math.addExact(3,5));
        System.out.println(Math.pow(2, 16));
        Collections.sort(Lists.<Comparable>newArrayList(), new Comparator<Comparable>() {
            @Override
            public int compare(Comparable o1, Comparable o2) {
                return 0;
            }
        });
    }

    @Test
    public void stringTest(){
//        System.out.println(String.join(",", Lists.<CharSequence>newArrayList("He", "She", "They")));
//        System.out.println(String.join(",", new String[]{"He", "She", "They"}));
//        System.out.println(String.join(",", "Peter", "Paul", "Mary"));
        char c = '/';
        System.out.println((int)c);
        String str = "abcdabc";
        // 编码点 参考《写给大忙人看的Java核心技术》 Page25
//        System.out.println(new Gson().toJson(str.codePoints().toArray()));
        /*
            8.2f中8代表输出的宽度，且默认是右对齐
            http://blog.csdn.net/Frank_Jay/article/details/50226273
            1$ 代表第一个参数
         */
        System.out.println(1234.567);
        System.out.printf("%1$8.2f", 1234.567);
        System.out.println();
        System.out.printf("%1$#f", 1234.);
        System.out.println();
    }

    public static void main(String[] args) {
        NormalTest test = new NormalTest();
        test.consoleTest();
/*        Videoconference conference = new Videoconference(9);
        Thread threadConference = new Thread(conference);
        threadConference.start();
        for(int i=0;i<10;i++){
            Participant p = new Participant(conference, "Participant"+i);
            Thread t = new Thread(p);
            t.start();
        }*/
    }

    /**
     * terminal在IDE中运行为null, 应该以命令启动
     */
    public void consoleTest(){
        Console terminal = System.console();
        String username = terminal.readLine("User name:");
        char[] password = terminal.readPassword("Password:");
        System.out.println(username + " " + new String(password));
    }

    @Test
    public void formatTest(){
        System.out.println(String.format("%06d", 120));
    }

    /**
     * 公安局破案问题
     */
    @Test
    public void applicationTest(){
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    for (int d = 0; d < 2; d++) {
                        if(a == 0 && b == 0){
                            continue;
                        }
                        if(b == 0 && c == 0){
                            continue;
                        }
                        if(c == 0 && d == 0){
                            continue;
                        }
                        if(a == 1 && c == 1){
                            continue;
                        }
                        if(b == 1 && d == 1){
                            continue;
                        }
                        System.out.println("赵" + (a == 1 ? "是" : "不是") + "作案人");
                        System.out.println("钱" + (b == 1 ? "是" : "不是") + "作案人");
                        System.out.println("孙" + (c == 1 ? "是" : "不是") + "作案人");
                        System.out.println("李" + (d == 1 ? "是" : "不是") + "作案人");
                    }
                }
            }
        }
    }

    @Test
    public void nullPointerTest(){
        System.out.println(Arrays.asList("He", "She"));
    }

    /**
     * 多线程调试 使用单元测试会有问题，使用main方法debug正常（多线程内代码能停留）
     * Suspend: All 挂起所有线程; 多线程调试时，需要把Suspend改为Thread
     */
    @Test
    public void multiplyThreadDebugTest() throws InterruptedException {
        multiplyThread();
    }

 /*   public static void main(String[] args) throws InterruptedException {
        multiplyThread();
    }*/

    public static void multiplyThread() throws InterruptedException {
        String str = "Hello Kite!";
        System.out.println(str + ", Are you OK ?");
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println("First breakPoint!");
                System.out.println("Two breakPoint!");
            }
        }.start();
        System.out.println("Three breakPoint!");
        Thread.sleep(1000);
        System.out.println("Four breakPoint!");
    }

    @Test
    public void testUnitVolume(){
        System.out.println(1<<33);
        System.out.println(Math.pow(2,30));
        System.out.println(getUnitVolume("100*250*400", 4));
    }

    private BigDecimal getUnitVolume(String outerPackingSize, Integer packingValue){
        if(outerPackingSize != null && outerPackingSize.length() > 0){
            List<String> strList = Splitter.on("*").omitEmptyStrings().trimResults()
                    .splitToList(outerPackingSize);
            BigDecimal unitVolume = BigDecimal.ONE;
            for (String str : strList) {
                unitVolume = unitVolume.multiply(new BigDecimal(str));
            }
            unitVolume = unitVolume.divide(BigDecimal.valueOf(packingValue,-9), 3, BigDecimal.ROUND_HALF_UP);
            return unitVolume;
        }else{
            return BigDecimal.valueOf(0.000);
        }
    }

    @Test
    public void testBigDecimal(){
        Double dd= Double.valueOf("0.00864567");
        BigDecimal bigD = new BigDecimal(dd);
        MathContext mc = new MathContext(4,RoundingMode.HALF_UP);
        //4表示取四位有效数字，RoundingMode.HALF_UP表示四舍五入
        bigD= bigD.multiply(new BigDecimal(100),mc);
        System.out.println(bigD.toString());
        System.out.println(Float.MAX_VALUE);
        System.out.println(62345678.91234556f);
    }

    @Test
    public void testBigDecimalZero(){
        log.info("{}", new BigDecimal("0.00").equals(new BigDecimal("0.00")));
        log.info("{}", new BigDecimal(0.00).equals(BigDecimal.valueOf(0.00)));
        log.info("{}", new BigDecimal(0.00).equals(new BigDecimal("0.00")));
        log.info("{}", new BigDecimal(0).equals(BigDecimal.ZERO));
        log.info("{}", BigDecimal.ZERO.equals(BigDecimal.valueOf(0)));
        System.out.println(Integer.toBinaryString(39532));
        System.out.println(Math.log(4));
    }

    @Test
    public void testBigInteger(){
        System.out.println("http://tqmall-image.oss-cn-hangzhou.aliyuncs.com/erp/wms/1216/1469152951953.jpg".length());
    }


    @Test
    public void testRandom(){
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            System.out.println(random.nextInt(2));;
        }
    }

}
