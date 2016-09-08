package org.seckill.junit;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: xujiangjun
 * Date: 16/9/8 12:33
 */
public class RegexTest {

    /**
     * 校验日期格式字符串：yyyy-MM-dd HH:mm:ss
     * 同时校验每月的天数和时间，但是不校验润年和平年
     */
    @Test
    public void checkTimeFormatTest() throws ParseException {
        Pattern a = Pattern.compile("^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))" +
                "|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30))) " +
                "(([0-1][0-9])|(2[0-3])):([0-5][0-9]):([0-5][0-9])$");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = "1950-02-10 00:00:00";
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            Matcher b = a.matcher(str);
            System.out.println(b.matches());
        }
        System.out.println("Regex Time ==== " + (System.currentTimeMillis() - start));
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            sdf.parse(str);
        }
        System.out.println("Parse Time ==== " + (System.currentTimeMillis() - start2));
    }

    /**
     * 正则替换随机产生的UUID
     * 将手机号码的中间四位隐藏
     */
    @Test
    public void hiddenPartMobileTest(){
        String random = UUID.randomUUID().toString();
        System.out.println(random.replaceAll("-", ""));
        String mobile = "18770039115";
        System.out.println(mobile.replaceAll("(\\d{3})(\\d{4})(\\d{4})", "$1****$3"));
    }
}
