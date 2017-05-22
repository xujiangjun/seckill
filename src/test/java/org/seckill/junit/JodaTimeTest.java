package org.seckill.junit;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
        String time = "2017-04-26 08:44:00";
//        String time = "2016-10-20 20:30:30";
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
        String updateTime = new DateTime().plusMinutes(10).toString("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(updateTime);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 10);
        String updateTime1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(cal.getTime());
        System.out.println(updateTime1);
    }

    @Test
    public void testDays(){
        DateTime start = new DateTime();
        DateTime end = new DateTime().plusDays(1).plusSeconds(22).plusMinutes(50).plusSeconds(30);
        Period p = new Interval(start, end).toPeriod();
        System.out.println(p.getDays() + " " + p.getHours() + ":" + p.getMinutes() + ":" + p.getSeconds() + p.getMillis());
        System.out.println(start.toString("yyyy-MM-dd HH:mm:ss") + "-----------" + end.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(Days.daysBetween(start, end).getDays());
        System.out.println(Hours.hoursBetween(start, end).getHours());
        System.out.println(Days.daysBetween(end, start).getDays());
    }

    @Test
    public void testConvert(){
        System.out.println(new DateTime(new Date()).toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(new DateTime(new Date()).plusDays(1).withHourOfDay(19).withMinuteOfHour(59).withSecondOfMinute(59).toString("yyyy-MM-dd HH:mm:ss"));
    }
}
