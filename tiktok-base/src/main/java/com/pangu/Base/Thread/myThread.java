package com.pangu.Base.Thread;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-31 15:52
 * @desc:
 */
public class myThread implements Runnable {
    private int sum;

//    public myThread(int sum){
//        super();
//        this.sum = sum;
//    }

    @Override
    public void run() {
        try {
            sum++;
            System.out.println(Thread.currentThread().getName() + "===" + sum);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
