package com.pangu.Mq.consumer;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-23 19:46
 * @desc Mq配置自动装载
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Configuration
@EnableConfigurationProperties(MqMessageProperties.class)
public class MqMessageAutoConfiguration {

    @Resource
    MqMessageProperties mqMessageProperties;

    @Bean
    MqMessageEngine mqMessageEngineContainer() {
        return new MqMessageEngine(mqMessageProperties);
    }
}
