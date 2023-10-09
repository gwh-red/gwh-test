package com.gwh;


import cn.hutool.core.date.*;
import com.alibaba.fastjson.JSON;
import org.apache.http.impl.cookie.DateUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

public class DateTest {
    public static final String YYYMMDD_JFP_STR = "yyyyMMdd";

    private static final DateTimeFormatter YYYMMDD_JFP_FMT = DateTimeFormatter.ofPattern(YYYMMDD_JFP_STR);

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


    public static void main(String[] args) throws ParseException {

        Double distance = Double.valueOf("0.22175919834248473") * 1000d * 1.4d;
        System.out.println(distance);
        System.out.println(String.format("%.4f", distance));


        //获取秒数
        Long second = LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8"));
//获取毫秒数
        Long milliSecond = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();

        long l = System.currentTimeMillis();
        System.out.println(second + "----" + milliSecond + "--------" + l);


        Calendar ca = Calendar.getInstance();
        System.out.println(DateUtil.lastWeek());
        ca.setTime(DateUtil.lastWeek());
        int i1 = ca.get(Calendar.WEEK_OF_YEAR) == 1 ? 52 : ca.get(Calendar.WEEK_OF_YEAR) - 1;
        System.out.println(i1);
     /*   Calendar ca = Calendar.getInstance();

        ca.setTime(DateUtil.lastWeek());
        int i1 = ca.get(Calendar.WEEK_OF_YEAR) == 1 ? 52 : ca.get(Calendar.WEEK_OF_YEAR) - 1;
        System.out.println(i1);*/
//time:2364403  currentTime:1690361961457   Long.valueOf(lastTime):1690359597054
        //  1690362491548  Long.valueOf(lastTime):1690362491359
        Long long1 = Long.valueOf("1690362690114");
        Long long2 = Long.valueOf("1690362677900");
        //   Long.valueOf(lastTime):1690362677900
//currentTime:1690362601182   Long.valueOf(lastTime):1690362029915
        Date date = new Date(long1);
        Date date1 = new Date(long2);
        System.out.println(DateUtil.format(date, "yyyy-MM-dd HH:mm:ss"));
        System.out.println(DateUtil.format(date1, "yyyy-MM-dd HH:mm:ss"));
      /*  Date theFirstDayOfLastMonth = DateTest.getTheFirstDayOfLastMonth(-1);
        Date lastDayOfLastMonth = DateTest.getLastDayOfLastMonth(0);

        Date beginOfDay = DateUtil.beginOfDay(theFirstDayOfLastMonth);
        Date endOfDay = DateUtil.endOfDay(lastDayOfLastMonth);

        int year = DateUtil.year(beginOfDay);
        int month = DateUtil.month(new Date());

        System.out.println(theFirstDayOfLastMonth);
        System.out.println(lastDayOfLastMonth);
        System.out.println(beginOfDay);
        System.out.println(endOfDay);
        System.out.println(year);
        System.out.println(month);
*/

       /* LocalDate now = LocalDate.now();
        // 求这个日期上一周的周一、周日
        LocalDate todayOfLastWeek = now.minusDays(7);
        LocalDate monday = todayOfLastWeek.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1);
        LocalDate sunday = todayOfLastWeek.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).minusDays(1);


        LocalDateTime startTime = LocalDateTimeUtil.beginOfDay(monday.atStartOfDay());
        LocalDateTime endTime = LocalDateTimeUtil.endOfDay(sunday.atStartOfDay());

        int year = DateUtil.year(DateUtil.lastWeek());
        System.out.println(DateUtil.format(DateUtil.yesterday(), "MM-dd"));
        System.out.println(startTime);
        System.out.println(endTime);*/

        // 求这个日期上一周的周一、周日
   /*     LocalDate now = LocalDate.now();
        LocalDate todayOfLastWeek = now.minusDays(7);
        LocalDate monday = todayOfLastWeek.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY)).plusDays(1);
        System.out.println(monday);*/
   /*     Date theFirstDayOfLastMonth = getTheFirstDayOfLastMonth(-6);
        Date lastDayOfLastMonth = getLastDayOfLastMonth(-5);


        Date beginOfDay = DateUtil.beginOfDay(theFirstDayOfLastMonth);

        Date endOfDay = DateUtil.endOfDay(lastDayOfLastMonth);

        System.out.println(DateUtil.year(beginOfDay));
        System.out.println(DateUtil.month(beginOfDay));

        System.out.println(beginOfDay);
        System.out.println(endOfDay);*/
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
