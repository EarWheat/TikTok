package com.tiktok.Mq.consumer;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.MapUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-21 19:34
 * @desc Mq容器类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Component
public class MqMessageListenerContainer implements ApplicationContextAware {

    // mq消费容器
    // Map<Topic,<Group,MqMessageListener>>
    // 1个topic对应多个消费组
    private static Map<String, Map<String, MqMessageListener>> mqMessageListenerContainerMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        // 找到所有MqMessageListener的类及其子类
        Map<String, MqMessageListener> mqMessageListenerMap = applicationContext.getBeansOfType(MqMessageListener.class);
        if (MapUtils.isEmpty(mqMessageListenerMap)) {
            return;
        }

        mqMessageListenerContainerMap = new HashMap<>();

        // 获取所有Mq子类的Topic以及Group信息
        for(Map.Entry mqMessageListenerClazz : mqMessageListenerMap.entrySet()){
            MqMessageListener mqMessageListener = (MqMessageListener) mqMessageListenerClazz.getValue();
            MqMessageListenerConfig mqMessageListenerConfig = AnnotationUtils.findAnnotation(mqMessageListener.getClass(),MqMessageListenerConfig.class);
            if(mqMessageListenerConfig != null){
                String topic = mqMessageListenerConfig.topic();
                String group = mqMessageListenerConfig.consumerGroup();
                if(!mqMessageListenerContainerMap.containsKey(topic)){
                    Map<String, MqMessageListener> temp = new HashMap<>();
                    temp.put(group,mqMessageListener);
                    mqMessageListenerContainerMap.put(topic,temp);
                } else {
                    Map<String, MqMessageListener> temp = mqMessageListenerContainerMap.get(topic);
                    if (Objects.equals(temp.putIfAbsent(group, mqMessageListener), mqMessageListener)) {
                        throw new IllegalArgumentException("一个消费组不能订阅多个相同的topic");
                    }
                }
            }
        }
    }

    /**
     * 获取对应的消费实现类
     * @param group
     * @param topic
     * @return
     */
    static MqMessageListener getMqMessageListener(String group, String topic) {
        return mqMessageListenerContainerMap.get(topic).get(group);
    }

    public static Map<String, Map<String, MqMessageListener>> getMqMessageListenerContainerMap(){
        return mqMessageListenerContainerMap;
    }

}
