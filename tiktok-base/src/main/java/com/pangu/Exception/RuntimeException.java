package com.pangu.Exception;

import java.util.ArrayList;
import java.util.List;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-21 19:26
 * @desc:运行时异常
 */
public class RuntimeException {

    // 内存栈超过最大深度
    private static String StackOutOfFlow(String s){
        return s + StackOutOfFlow(s);
    }

    // 内存溢出
    private static void OutOfMemory(){
        List<String> list=new ArrayList<>();
        int i=0;
        while(true){
            i++;
            list.add(String.valueOf(i));
            if(i<0){
                break;
            }
        }
    }


    public static void main(String[] args) {
//        System.out.println(StackOutOfFlow("6"));
        OutOfMemory();
    }
}
