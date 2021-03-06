package com.pangu.Base.Thread;

import java.util.concurrent.CountDownLatch;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-31 16:16
 * @desc:
 */
public class zThread implements Runnable {

    private Integer sum;
    private CountDownLatch countDownLatch;

    public zThread(Integer sum, CountDownLatch countDownLatch){
        this.sum = sum;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run(){
        try {
            Thread.sleep((long) (Math.random() * 100));
            sum = sum + 1;
            System.out.println(Thread.currentThread().getName() + "===" + sum);
            countDownLatch.countDown();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
