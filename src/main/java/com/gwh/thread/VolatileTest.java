package com.gwh.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest {
    public static void main(String[] args) {

        MyData myData = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 100; j++) {
                    myData.addNumber();
                    myData.MyAtomicInteger();
                }
            }, String.valueOf(i)).start();
        }

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "                 " + myData.number);
        System.out.println(Thread.currentThread().getName() + "                 " + myData.a);
    }
}


class MyData {
    volatile int number = 0;

    public void addNumber() {
        number++;
    }

    AtomicInteger a = new AtomicInteger();

    public void MyAtomicInteger() {
        a.getAndIncrement();
    }
}