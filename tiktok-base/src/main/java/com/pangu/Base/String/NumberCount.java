package com.pangu.Base.String;

import java.util.concurrent.CountDownLatch;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-07 17:28
 * @desc:
 */
public class NumberCount implements Runnable {
    private int count;
    private CountDownLatch countDownLatch;

    public NumberCount(int count,CountDownLatch countDownLatch){
        this.count = count;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        count++;
        System.out.println(Thread.currentThread().getName() + "====" + count);
        countDownLatch.countDown();
    }
}
