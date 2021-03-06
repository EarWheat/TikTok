package com.pangu.Base.BaseNumType;

/*
 * @author:liuzhaolu
 * @createTime: 2020-07-25 14:48
 * @desc: 测试自动装箱
 */
public class IntegerTest {
    public static void main(String[] args) {
        Integer a = new Integer(3);
        Integer b = 3;          // 将3自动装箱成Integer
        int c = 3;
        System.out.println(a == b);     // false a是new的一个新的类，开辟了新的内存空间， 属于不同的内存空间
        System.out.println(a == c);     // true a自动拆箱成int类型，再和c比较
        System.out.println(b == c);     // true 同上

        Integer num1 = 100, num2 = 100, num3 = 150, num4 = 150;
        System.out.println(num1 == num2);   // true
        /**
         * false
         * ==运算比较的不是值而是引用。装箱的本质是什么呢？当我们给一个Integer对象赋一个int值的时候，会调用Integer类的静态方法valueOf
         * 如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，会新new一个Integer对象
         */
        System.out.println(num3 == num4);

    }
}
