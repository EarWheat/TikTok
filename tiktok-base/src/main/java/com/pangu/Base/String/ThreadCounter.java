package com.pangu.Base.String;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-07 17:20
 * @desc: 多线程计数统计
 */
public class ThreadCounter {
    private static int count = 0;
    private static CountDownLatch countDownLatch = new CountDownLatch(10000);
    private static int corePoolSize = 10;
    private static int maxThreadSize = 20;
    private static int keepAliveTime = 300;
    private static ArrayBlockingQueue<Runnable> arrayBlockingQueue = new ArrayBlockingQueue<>(10000);

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize,maxThreadSize,keepAliveTime, TimeUnit.MILLISECONDS,arrayBlockingQueue);
//        ThreadCounter threadCounter = new ThreadCounter();
//        NumberCount numberCount = new NumberCount(threadCounter.count, countDownLatch);
        try {
            for(int i = 0; i < 10000; i++){
                threadPoolExecutor.execute(new Runnable() {
                    @Override
                    public void run() {
                        increase();
                        countDownLatch.countDown();
                    }
                });
            }
            countDownLatch.await();
            System.out.println(count);
            threadPoolExecutor.shutdown();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static synchronized void increase(){
        count++;
    }

}
