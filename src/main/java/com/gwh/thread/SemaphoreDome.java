package com.gwh.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore用例
 * 抢车位
 *
 * @author 123
 */
public class SemaphoreDome {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);

        //forthread
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "抢到了车位");
                     try {
                             TimeUnit.SECONDS.sleep(3);
                      } catch (InterruptedException e) {
                             e.printStackTrace();
                      }
                    System.out.println(Thread.currentThread().getName() + "离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }

            }, String.valueOf(i)).start();
        }
    }
}
