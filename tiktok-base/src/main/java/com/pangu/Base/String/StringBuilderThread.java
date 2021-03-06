package com.pangu.Base.String;

import java.util.concurrent.CountDownLatch;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-28 19:47
 * @desc:
 */
public class StringBuilderThread implements Runnable {

    private StringBuilder stringBuilder;
    private CountDownLatch countDownLatch;

    public StringBuilderThread(StringBuilder stringBuilder, CountDownLatch countDownLatch){
        super();
        this.stringBuilder = stringBuilder;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
//            System.out.println(Thread.currentThread().getName() + "-就绪");
            countDownLatch.countDown();
            countDownLatch.await();
            Thread.sleep((long) (Math.random() % 1000));
            stringBuilder.append("a");
//            System.out.println(Thread.currentThread().getName() + "-" + stringBuilder.length());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
