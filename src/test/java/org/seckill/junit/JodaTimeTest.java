package org.seckill.junit;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.util.Locale;
import java.util.TimeZone;

/**
 * @author xujiangjun
 * @version 1.0
 * @date 2016-10-26 11:25
 */
public class JodaTimeTest {

    @Test
    public void test(){
        String time = "2016-10-20 20:30:30";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.parseDateTime(time).toString("yyyy-MM-dd hh:mm:ss"));
        System.out.println(formatter.parseLocalDate(time).dayOfMonth().get());
        DateTime dt = new DateTime();
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss.SSS"));
        System.out.println(dt.withMillisOfSecond(900).toString("yyyy-MM-dd HH:mm:ss.SSS"));
    }

    @Test
    public void timeZoneTest(){
        TimeZone tz = TimeZone.getDefault();
        System.out.println(tz.getID() + tz.getDisplayName());
        Locale locale = Locale.getDefault();
        System.out.println(locale.toString());
    }

    @Test
    public void test2(){
        String month = "2016-02";
        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM");
        DateTime dt = formatter.parseDateTime(month);
        System.out.println(dt.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(dt.dayOfMonth().withMaximumValue()
                .millisOfDay().withMaximumValue().toString("yyyy-MM-dd HH:mm:ss"));
    }

    @Test
    public void test3(){
        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void test4(){
    }
}
