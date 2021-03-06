package com.pangu.Base.String;

import java.util.concurrent.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 15:15
 * @desc:Java基础,StringBuffer与StringBuilder
 *
 */
public class StringTest {

    private static int times = 1000;
    private static StringBuffer stringBuffer = new StringBuffer();
    private static StringBuilder stringBuilder = new StringBuilder();
    private static CountDownLatch countDownLatch = new CountDownLatch(4000);
    private static CountDownLatch countDownLatch1 = new CountDownLatch(times);
    private static CountDownLatch countDownLatch2 = new CountDownLatch(times);

    public static void main(String[] args) throws InterruptedException {
        // 同一个线程操作N次
        Thread thread1 = new Thread(new SingleBufferThread(stringBuffer,countDownLatch));
        Thread thread2 = new Thread(new SingleBufferThread(stringBuffer,countDownLatch));
        Thread thread3 = new Thread(new SingleBuilderThread(stringBuilder,countDownLatch));
        Thread thread4 = new Thread(new SingleBuilderThread(stringBuilder,countDownLatch));
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        countDownLatch.await();
        System.out.println("SingleThread StringBuffer:" + stringBuffer.length());
        System.out.println("SingleThread StringBuilder:" + stringBuilder.length());

        stringBuilder.delete(0,stringBuilder.length());
        stringBuffer.delete(0,stringBuffer.length());

        // 启动多个线程去执行
        for(int i = 0; i < times; i++){
            new Thread(new StringBufferThread(stringBuffer,countDownLatch1)).start();
        }
        for(int i = 0; i < 1000; i++){
            new Thread(new StringBuilderThread(stringBuilder,countDownLatch2)).start();
        }
        countDownLatch1.await();
        countDownLatch2.await();
        System.out.println("stringBuffer:" + stringBuffer.length());
        System.out.println("stringBuilder:" + stringBuilder.length());

    }
}
