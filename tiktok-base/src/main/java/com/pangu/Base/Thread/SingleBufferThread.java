package com.pangu.Base.Thread;

import java.util.concurrent.CountDownLatch;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-29 19:09
 * @desc:
 */
public class SingleBufferThread implements Runnable {

    private StringBuffer stringBuffer;
    private CountDownLatch countDownLatch;

    public SingleBufferThread(StringBuffer stringBuffer, CountDownLatch countDownLatch){
        super();
        this.stringBuffer = stringBuffer;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 100));
            stringBuffer.append("a");
            countDownLatch.countDown();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
