package com.gwh;

import java.util.concurrent.CountDownLatch;

public class WaitSubThread {
    public static void main(String args[]){
        CountDownLatch runingNum = new CountDownLatch(5);
        for(int i=0;i<5;i++){
            new Thread(new SubTest(runingNum)).start();
        }
        try {
            runingNum.await(); //等待所有的线程结束，如果有线程没有结束，主线程一直阻塞
            System.out.println("主线程结束工作");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
class SubTest implements Runnable{
    private CountDownLatch runingNum;
    public SubTest(CountDownLatch runingNum){
        this.runingNum = runingNum;
    }
    @Override
    public void run() {
        System.out.println("新线程开始工作");
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        System.out.println("线程结束工作");
        runingNum.countDown();//标识当前线程执行结束

    }

}

