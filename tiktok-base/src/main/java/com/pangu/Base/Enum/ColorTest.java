package com.pangu.Base.Enum;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 14:39
 * @desc:测试枚举类
 */
public class ColorTest {
    public static void main(String[] args) {
        System.out.println(Color.RED);
        System.out.println(Color.RED.equals(Color.GREEN));
        Color color = Color.RED;
        switch (color){
            case RED:
                System.out.println("hello  "+color);
                break;
            case BLANK:
                System.out.println("hello   "+color);
                break;
        }
    }
}
