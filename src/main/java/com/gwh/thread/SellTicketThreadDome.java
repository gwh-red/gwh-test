package com.gwh.thread;

import lombok.Getter;

import java.util.concurrent.TimeUnit;

/**
 * 售票
 *
 * @author 123
 */
public class SellTicketThreadDome {

    public static void main(String[] args) {
        SellTicket sellTicket = new SellTicket();
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 10; j++) {
                    sellTicket.sell();
                    System.out.println(Thread.currentThread().getName() + "号售票员正在售票：" + sellTicket.getTicke());
                }
            }, String.valueOf(i)).start();
        }
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "号售票员正在售票：" + sellTicket.getTicke());
    }
}

class SellTicket {

    @Getter
    private Integer ticke = 50;

    public void sell() {
        ticke--;
    }
}
