package com.pangu.Mq.consumer;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/*
 * @author:liuzhaolu
 * @createTime: 2020-01-10 16:57
 * @desc:
 */
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface MqMessageListenerConfig {
    String topic();

    String consumerGroup();

    String tags() default "";
}
