package com.gwh;


import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JavaTast {

    /**
     * 保留两位小数，四舍五入的一个老土的方法
     *
     * @param d
     * @return
     */
    public static double formatDouble1(double d) {
        return (double) Math.round(d * 100) / 100;
    }


    /**
     * The BigDecimal class provides operations for arithmetic, scale manipulation, rounding, comparison, hashing, and format conversion.
     *
     * @param d
     * @return
     */
    public static double formatDouble2(double d) {
        // 旧方法，已经不再推荐使用
//        BigDecimal bg = new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);


        // 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
        BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.UP);


        return bg.doubleValue();
    }

    /**
     * NumberFormat is the abstract base class for all number formats.
     * This class provides the interface for formatting and parsing numbers.
     *
     * @param d
     * @return
     */
    public static String formatDouble3(double d) {
        NumberFormat nf = NumberFormat.getNumberInstance();


        // 保留两位小数
        nf.setMaximumFractionDigits(2);


        // 如果不需要四舍五入，可以使用RoundingMode.DOWN
        nf.setRoundingMode(RoundingMode.UP);


        return nf.format(d);
    }


    /**
     * 这个方法挺简单的。
     * DecimalFormat is a concrete subclass of NumberFormat that formats decimal numbers.
     *
     * @param d
     * @return
     */
    public static String formatDouble4(double d) {
        DecimalFormat df = new DecimalFormat("#.00");


        return df.format(d);
    }


    /**
     * 如果只是用于程序中的格式化数值然后输出，那么这个方法还是挺方便的。
     * 应该是这样使用：System.out.println(String.format("%.2f", d));
     *
     * @param d
     * @return
     */
    public static String formatDouble5(double d) {
        return String.format("%.2f", d);
    }

    public void ss(Pageable n) {

    }

    public static void main(String[] args) {
        // LocalDateTime localDateTime = LocalDateTimeUtil.parse("2021-01- 12:23:56");

// 增加一天
// "2020-01-24T12:23:56"
      /*  LocalDateTime offset = LocalDateTimeUtil.offset(LocalDateTime.now(), 10, ChronoUnit.DAYS);
        System.out.println(offset);
        System.out.println(LocalDateTimeUtil.format(LocalDateTimeUtil.beginOfDay(offset), DatePattern.NORM_DATETIME_PATTERN));
        System.out.println(LocalDateTimeUtil.format(LocalDateTimeUtil.endOfDay(offset), DatePattern.NORM_DATETIME_PATTERN));*/

/*
        LocalDateTime end = LocalDateTimeUtil.parse("2021-11-04T12:22:59");

        Duration between = LocalDateTimeUtil.between(LocalDateTime.now(), end);

// 365
        System.out.println(between.toDays());
        System.out.println(between.toHours());
        System.out.println(between.toMillis());
        System.out.println(between.toString());
        System.out.println(between.toNanos());*/

        /*String dateStr1 = "2021-11-07 23:59:59";
        Date date1 = DateUtil.parse(dateStr1);

        String dateStr2 = "2021-11-04 ";
        Date date2 = DateUtil.parse(dateStr2);

//相差一个月，31天
        long betweenDay = DateUtil.between(date1, date2,DateUnit.DAY);
        System.out.println(betweenDay);*/
    }


}
