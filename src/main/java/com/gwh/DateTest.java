package com.gwh;

import cn.hutool.core.date.*;
import cn.hutool.core.util.NumberUtil;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {

    public static Date addHour(int hour) {
        return localDateTime2Date(LocalDateTime.now().plusHours((long) hour));
    }

    public static Date localDateTime2Date(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意三个参数的时间格式要一致
     *
     * @param nowTime
     * @param startTime
     * @param endTime
     * @return 在时间段内返回true，不在返回false
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }

        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        return date.after(begin) && date.before(end);
    }

    public static void main(String[] args) {
        LocalDate localDate111 = null;
        localDate111 = LocalDateTimeUtil.parseDate("2020-01-23 12:23:56", DateTimeFormatter.ISO_DATE_TIME);
        System.out.println(localDate111);

        //LocalDateTime parse = LocalDateTimeUtil.parse("2020-01-23T12:23");
        //System.out.println(parse);


        String format1 = LocalDateTimeUtil.format(LocalDateTime.now(), DatePattern.NORM_DATETIME_MINUTE_PATTERN);
        System.out.println(format1);
      /*  System.out.println(localDateTime2Date(LocalDateTime.now()));


        String strStartTime1 = "00:00:00";
        String strEndTime1 = "20:00:00";

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String now = sdf.format(new Date());
        Date nowTime;
        try {
            nowTime = sdf.parse(now);
            Date startTime1 = sdf.parse(strStartTime1);
            Date endTime1 = sdf.parse(strEndTime1);
            // 注：也可以通过此方式判断当前时间是否具体时间段内 yyyy-MM-dd HH:mm:ss格式 [2022-03-09 12:00:00,2022-03-10 15:00:00]
            //   当前时间和时间段的格式保持一致即可判断
            if (isEffectiveDate(nowTime, startTime1, endTime1)) {
                System.out.println("当前时间在时间段内[" + strStartTime1 + "," + strEndTime1 + "]");
            } else {
                System.out.println("当前时间不再时间段内[" + strStartTime1 + "," + strEndTime1 + "]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
*/


        LocalDateTime offset = LocalDateTimeUtil.offset(LocalDateTime.now(), 10, ChronoUnit.SECONDS);
        System.out.println(offset);


        System.out.println(DateTest.getBeginDayOfYesterday());

        System.out.println(DateUtil.parse("20220413", "yyyyMMdd"));

        Date date1 = new Date();

        DateTime newDate2 = DateUtil.offsetDay(date1, -60);
        System.out.println(DateUtil.format(DateUtil.offsetDay(date1, -60), "yyyyMMdd"));

        String format = DateUtil.format(new Date(), "yyyyMMdd");
        System.out.println(format);
        System.out.println(DateUtil.format(DateUtil.yesterday(), "yyyyMMdd"));
        DateTime date = DateUtil.parse(DateUtil.yesterday().toString());

        //一天的开始，结果：2017-03-01 00:00:00
        Date beginOfDay = DateUtil.beginOfDay(date);

        //一天的结束，结果：2017-03-01 23:59:59
        Date endOfDay = DateUtil.endOfDay(date);

        System.out.println(date + "           " + beginOfDay + "              " + endOfDay + "             ");


        LocalDateTime time = LocalDateTime.now();

        System.out.println(time);

        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        String strDate2 = dtf2.format(time);
        System.out.println(strDate2);

    }

    /**
     * 获取某一个月的第一天 （-1 上个月  1 下个月）
     *
     * @param month 负数减当前月 整数加当前月
     * @return
     */
    public static Date getTheFirstDayOfLastMonth(Integer month) {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, month);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        return cale.getTime();
    }

    /**
     * 获取某月的最后一天（-1 上上个月 ）
     *
     * @return
     */
    public static Date getLastDayOfLastMonth(Integer month) {
        Calendar cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, month);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        return cale.getTime();
    }


    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
        cal.add(Calendar.DAY_OF_MONTH, -1);
        return cal.getTime();
    }

    public static Date getDayBegin() {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

}
