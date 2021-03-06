package com.pangu.Base.Thread;

import java.util.concurrent.CountDownLatch;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-29 19:09
 * @desc:
 */
public class SingleBuilderThread implements Runnable {

    private StringBuilder stringBuilder;
    private CountDownLatch countDownLatch;

    public SingleBuilderThread(StringBuilder stringBuilder, CountDownLatch countDownLatch){
        super();
        this.stringBuilder = stringBuilder;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 100));
            stringBuilder.append("a");
            countDownLatch.countDown();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
