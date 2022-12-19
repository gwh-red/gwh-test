package com.gwh;

import java.math.BigDecimal;

public class dome01 {

    public static void main(String[] args) {
        //dome1();
        //dome2();
        // dome3();

        BigDecimal a= new BigDecimal(1);
        BigDecimal divide = a.divide(new BigDecimal(1000), 3, BigDecimal.ROUND_DOWN);
        System.out.println(divide);
        double ceil = Math.ceil(divide.doubleValue());
        System.out.println(ceil);

/*        BigDecimal subtract = new BigDecimal(-1);
        BigDecimal bigDecimal = BigDecimal.valueOf(Math.max(subtract.doubleValue(), 0));
        System.out.println(bigDecimal);*/
    }

    /**
     *
     */
    public static void dome3() {
        //1000 0000
        //1100 0000
        //System.out.println(128 | 63);
        System.out.println(10 >> 3);
    }

    /**
     * 逻辑运算符^
     * 左右两边为相同   false  两边不同true
     */
    public static void dome2() {
        //1000 0000
        //1100 0000
        //System.out.println(128 | 63);
        System.out.println(10 & 1);
    }


    /**
     * 逻辑运算符^
     * 左右两边为相同   false  两边不同true
     */
    public static void dome1() {
        System.out.println(true ^ false);
        System.out.println(true ^ true);
        System.out.println(false ^ false);
    }
}
