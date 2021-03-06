package com.pangu.Mq.consumer;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;

import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-23 14:47
 * @desc mq引擎类，执行mq消费
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class MqMessageEngine{
    private static final Logger logger = LoggerFactory.getLogger(MqMessageEngine.class);

    MqMessageEngine(MqMessageProperties mqMessageProperties) {
        int corePoolSize = 10;
        int maximumPoolSize = 20;
        long keepAliveTime = 10000;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
        Map<String, Map<String, MqMessageListener>> mqMessageListener = MqMessageListenerContainer.getMqMessageListenerContainerMap();
        if(mqMessageListener == null){
            return;
        }
        for(Map.Entry listener : mqMessageListener.entrySet()){
            String topic = (String) listener.getKey();
            Map<String, MqMessageListener> listenerClazz = (Map<String, MqMessageListener>) listener.getValue();
            for(Map.Entry listenerConsumer: listenerClazz.entrySet()){
                String group = (String) listenerConsumer.getKey();
                MqMessageListener messageListener = (MqMessageListener) listenerConsumer.getValue();
                if(StringUtils.isNotBlank(topic) && StringUtils.isNotBlank(group)){
                    mqMessageProperties.setTopic(topic);
                    mqMessageProperties.setGroup(group);
                    threadPoolExecutor.execute(new MqMessageConsumerRunnable(mqMessageProperties, messageListener));
                }
            }
        }
    }

    @Bean
    public MqMessageProperties mqMessageProperties(){
        return new MqMessageProperties();
    }



}
