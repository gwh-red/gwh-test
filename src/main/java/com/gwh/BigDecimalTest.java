package com.gwh;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BigDecimalTest {
    public static void main(String[] args) {
        /*BigDecimal bigDecimal = new BigDecimal("16.9");

        System.out.println(bigDecimal.subtract(new BigDecimal("95.55").multiply(new BigDecimal("0.006"))).setScale(2, BigDecimal.ROUND_HALF_UP));*/
        Integer count = 0;
        if (count != null && count > 0) {
            System.out.println(count > 0);
        }
        if (new BigDecimal(0.00).compareTo(BigDecimal.ZERO)==0) {
            System.out.println(1);
        }

        Map<String, Object> map = new HashMap<>();
        map.put("totprive", 45);
        map.put("totnum", 14);

        // System.out.println(new BigDecimal(map.get("totprive").toString()).divide(new BigDecimal(map.get("totprive").toString())));


//        System.out.println(new BigDecimal(0.2).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());// 0.2
//        System.out.println(new BigDecimal(0.235).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());// 0.23
//        System.out.println(new BigDecimal(0.235).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());// 0.24
//        System.out.println(new BigDecimal(42).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());// 42.0
        System.out.println(new BigDecimal(map.get("totprive").toString()).divide(new BigDecimal(map.get("totnum").toString()), 2, BigDecimal.ROUND_CEILING));










       /* System.out.println(((BigDecimal) map.get("totprive")).divide(((BigDecimal) map.get("totnum"))));


        //System.out.println(new BigDecimal(map.get("totprive")).divide(new BigDecimal((char[]) map.get("totnum"))));
        if (map.get("totprive") instanceof Number) {
            System.out.println(new BigDecimal(((Number) map.get("totprive")).doubleValue()));
        }*/
    }


}
