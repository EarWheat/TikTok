package com.pangu.Monitor.Http;

import java.lang.annotation.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-05-26 16:30
 * @desc:自定义注解，会打印rest接口的耗时，
 * 可设置超时时间，rest耗时到达一定阈值报警
 */
//注解信息会被添加到Java文档中
@Documented
//注解的生命周期，表示注解会被保留到什么阶段，可以选择编译阶段、类加载阶段，或运行阶段
@Retention(RetentionPolicy.RUNTIME)
//注解作用的位置，ElementType.METHOD表示该注解仅能作用于方法上
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface HttpMonitor {
}
