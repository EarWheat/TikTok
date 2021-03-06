package com.pangu.Base.Thread;

import java.util.concurrent.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-31 17:03
 * @desc:
 */
public class ThreadPool {

    public static void main(String[] args) {
        int corePoolSize = 5;
        int maximumPoolSize = 10;
        long keepAlive = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAlive, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
        StringBuffer stringBuffer = new StringBuffer();
        CountDownLatch countDownLatch = new CountDownLatch(100);
        SingleBufferThread singleBufferThread = new SingleBufferThread(stringBuffer,countDownLatch);
        for(int i =0; i < 100; i++){
            threadPoolExecutor.execute(singleBufferThread);
        }
        try {
            countDownLatch.await();
            System.out.println(stringBuffer.length());
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
