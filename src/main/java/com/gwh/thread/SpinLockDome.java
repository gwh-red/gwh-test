package com.gwh.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 自旋锁
 *
 * @author 123
 */
public class SpinLockDome {

    AtomicReference<Integer> reference = new AtomicReference<>();

    Integer i = 1;

    public void myLock() {

        System.out.println(Thread.currentThread().getName() + " /t  myLock");
        while (!reference.compareAndSet(null, i)) {

        }
    }

    public void myUnLock() {
        reference.compareAndSet(i, null);
        System.out.println(Thread.currentThread().getName() + " /t  myUnLock");
    }

    public static void main(String[] args) {
        SpinLockDome spinLockDome = new SpinLockDome();

        new Thread(() -> {
            spinLockDome.myLock();
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDome.myUnLock();
        }, "t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLockDome.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLockDome.myUnLock();
        }, "t2").start();
    }
}
