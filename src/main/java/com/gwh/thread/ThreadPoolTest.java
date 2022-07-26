package com.gwh.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.List;
import java.util.Set;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ThreadPoolTest {
    public static void main(String[] args) {
        //线程池的七个参数
        //1.核心线程数
        //2.最大线程数
        //3.最大空闲时间
        //4.时间单位
        //5.阻塞队列
        //6.线程工厂
        //7.拒绝策略
       /* ExecutorService threadPoolExecutor = new ThreadPoolExecutor(3,
                5,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());*/

        // 获取所有线程
        Set<Thread> threads = Thread.getAllStackTraces().keySet();
        List<String> threadsNameList = threads.stream().map(Thread::getName).collect(Collectors.toList());
        //threads.forEach(System.out::println);

        if (!threadsNameList.contains("threadName")) {
            //Thread.currentThread().setName("threadName");
            Thread.currentThread().setName("pool-1");
        }
        // 修改线程名【可根据任务的某些参数对线程进行重命名】


        // 根据线程名称指定任务
        /*if (Thread.currentThread().getName().equals("threadName")) {
            // 业务代码
        }*/
        for (int i = 0; i < 10; i++) {
            try {
                //System.out.println(k);
                if (Thread.currentThread().getName().equals("pool-1")) {
                    executor.execute(() -> {
                        System.out.println(Thread.currentThread().getName() + "=======办理业务---------");
                    });
                }
            } catch (Exception e) {
                executor.shutdown();

            }

        }

        executor.shutdown();

    }


    private static int corePoolSize = Runtime.getRuntime().availableProcessors();

    private static ThreadFactory namedFactory = new ThreadFactoryBuilder().setNameFormat("ods-%d").build();

    /**
     * corePoolSize用于指定核心线程数量
     * maximumPoolSize指定最大线程数
     * keepAliveTime和TimeUnit指定线程空闲后的最大存活时间
     */
    public static ExecutorService executor = new ThreadPoolExecutor(corePoolSize,
            corePoolSize + 1,
            10L,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1000),
            namedFactory,
            new ThreadPoolExecutor.AbortPolicy());


}
