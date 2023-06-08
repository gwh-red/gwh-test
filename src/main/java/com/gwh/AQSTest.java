package com.gwh;


import cn.hutool.core.util.NumberUtil;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class AQSTest {

    private final static String NAME = "123";

    public static void main(String[] args) {
        /*ReentrantLock lock = new ReentrantLock();

        try {
            lock.lock();

        }finally {
            lock.unlock();
        }*/
        BigDecimal mul = NumberUtil.mul(new BigDecimal("5"), new BigDecimal("5"));
        System.out.println(mul);
        long l = System.currentTimeMillis();
        try {


            System.out.println(l);
            TimeUnit.MILLISECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - l);
       /* Map<String, Object> params = new HashMap<>();

        params.put("page", "1");
        params.put("ddd", "dd");
        params.put("aaa", "aaa");
        params.put("ccc", "ccc");


        StringBuilder valueSb1 = new StringBuilder();
        // 将参数以参数名的字典升序排序
        Map<String, Object> sortParams = new TreeMap<String, Object>(params);

        Set<Map.Entry<String, Object>> entrys = sortParams.entrySet();
        // 遍历排序的字典,并拼接value1+value2......格式
        for (Map.Entry<String, Object> entry : entrys) {
            System.out.println(entry.getKey() + "=" + entry.getValue() + "&");
            //valueSb1.append(entry.getKey()+"="+entry.getValue()+"&");
        }*/

    }


}
