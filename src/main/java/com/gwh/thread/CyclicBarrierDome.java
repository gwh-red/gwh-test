package com.gwh.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrier使用案例
 * 人齐开会，集齐龙珠召唤神龙
 *
 * @author 123
 */
public class CyclicBarrierDome {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> {
            System.out.println("召唤神龙");
        });

        for (int i = 1; i <= 7; i++) {
            new Thread(() -> {
                System.out.println("第" + Thread.currentThread().getName() + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

    }
}
