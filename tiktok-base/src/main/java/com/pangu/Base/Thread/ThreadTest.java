package com.pangu.Base.Thread;

import java.util.concurrent.CountDownLatch;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-31 14:49
 * @desc:线程测试类
 */
public class ThreadTest {
    // 静态变量
    private static volatile int num;

    public static void main(String[] args) {
        int times = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(times);
        // 非线程安全
        Integer sum = 0;
        zThread zThread = new zThread(sum,countDownLatch);
        for(int i = 0; i < times; i++){
            new Thread(zThread).start();
        }
        try {
            countDownLatch.await();
            System.out.println("main thread:" + sum);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        // StringBuffer线程安全
//        StringBuffer stringBuffer = new StringBuffer();
//        SingleBufferThread singleBufferThread = new SingleBufferThread(stringBuffer,countDownLatch);
//        for(int i = 0; i < times; i++){
//            new Thread(singleBufferThread).start();
//        }
//        try {
//            countDownLatch.await();
//            System.out.println("main thread:" + stringBuffer.length());
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }

        // StringBuilder非线程安全
//        StringBuilder stringBuilder = new StringBuilder();
//        SingleBuilderThread singleBuilderThread = new SingleBuilderThread(stringBuilder,countDownLatch);
//        for(int i = 0; i < times; i++){
//            new Thread(singleBuilderThread).start();
//        }
//        try {
//            countDownLatch.await();
//            System.out.println("main thread:" + stringBuilder.length());
//        } catch (InterruptedException e){
//            e.printStackTrace();
//        }
    }

}
