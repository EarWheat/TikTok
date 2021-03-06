package com.pangu.Base.JVM;

/*
 * @author:liuzhaolu
 * @createTime: 2020-08-05 17:52
 * @desc:JVM基础
 */
public class JVMBase {
    public static void main(String[] args) {
        /**
         * 栈空间操作起来最快但是栈很小，通常大量的对象都是放在堆空间
         * 语句中变量str放在栈上，用new创建出来的字符串对象放在堆上，而”hello”这个字面量放在静态区
         * 栈是线程私有的，堆是公共共享变量
         */
        String str = new String("hello");
    }
}
