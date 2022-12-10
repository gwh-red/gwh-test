package com.gwh;


import java.time.LocalDateTime;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author 123
 */
public class BlockingQueueDome {

    public static void main(String[] args) throws InterruptedException {
        //BlockingQueue<String>

        //获取当前时间
        LocalDateTime nowTime= LocalDateTime.now();
        //自定义时间
        LocalDateTime endTime = LocalDateTime.of(2021, 10, 23, 14, 10, 10);
        //比较  如今的时间 在 设定的时间 之后  返回的类型是Boolean类型
        System.out.println(nowTime.isAfter(endTime));
        //比较   如今的时间 在 设定的时间 之前  返回的类型是Boolean类型
        System.out.println(nowTime.isBefore(endTime));
        //比较   如今的时间 和 设定的时候  相等  返回类型是Boolean类型
        System.out.println(nowTime.equals(endTime));


        BlockingQueue<String> strings = new SynchronousQueue<>();
        strings.put("1");

    }

    public void ArrayBlockingQueueDome() {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

//        System.out.println(blockingQueue.add("1"));
//        System.out.println(blockingQueue.add("2"));
//        System.out.println(blockingQueue.add("3"));
//        System.out.println(blockingQueue.add("1"));
//        System.out.println(blockingQueue.element());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove());
        //System.out.println(blockingQueue.remove());
    }
}
