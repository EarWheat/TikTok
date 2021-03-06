package com.pangu.Base.Interface;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-05 19:34
 * @desc:
 */
public abstract class Bird {

    private String name;

    public void fly(String flyAction){
        System.out.println(this.name + " 飞!");
    }

    public void voice() {
        System.out.println(this.name + " 叫!");
    }

}

