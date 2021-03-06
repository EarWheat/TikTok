package com.pangu.Base.String;

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
            for(int i = 0; i < 1000; i++){
                Thread.sleep((long) (Math.random() % 1000));
                stringBuffer.append("a");
                countDownLatch.countDown();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
