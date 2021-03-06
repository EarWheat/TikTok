package com.pangu.Base.Interface;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-05 19:37
 * @desc:
 */
public class Animal extends Bird implements Duck {
    public void voice(){
        System.out.println("哞");
    }
}
