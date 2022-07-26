package com.gwh;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @author 123
 */
public class BlockingQueueDome {

    public static void main(String[] args) throws InterruptedException {
        //BlockingQueue<String>

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
