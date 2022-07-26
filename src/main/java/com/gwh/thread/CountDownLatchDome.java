package com.gwh.thread;

import com.gwh.enums.ThreeCountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * CountDownLatchDome
 * CountDownLatch火箭发射器5,4,3,2,1 发射
 *
 * @author 123
 */
public class CountDownLatchDome {

    public static void main(String[] args) throws InterruptedException {

        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "国被灭");
                //--
                countDownLatch.countDown();
            }, ThreeCountryEnum.getThreeCountryEnum(i).getCode()).start();
        }

        // countDownLatch = 0才能往下走
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "秦国一统天下");

    }
}
