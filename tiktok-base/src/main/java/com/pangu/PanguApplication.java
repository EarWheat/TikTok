package com.pangu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-26 19:27
 * @desc:
 */
@SpringBootApplication
public class PanguApplication {

    private static final Logger logger = LoggerFactory.getLogger(PanguApplication.class);

    public static void main(String[] args) {
        // 注入上下文信息
        ApplicationContext context = SpringApplication.run(PanguApplication.class, args);
//        logger.info("test Log Config");
//        // 获取所有bean信息
//        String[] beans = context.getBeanDefinitionNames();
//        for (String beanName:beans){
//            System.out.println(beanName);
//        }
//        System.out.println("=========================");
//        Map<String,Object> annotations = context.getBeansWithAnnotation(MqMessageListenerConfig.class);
//        Config config = (Config)annotations.get("config");  // 找到有该注解的类
//        MqMessageListenerConfig mqMessageListenerConfig = AnnotationUtils.findAnnotation(config.getClass(),MqMessageListenerConfig.class);
//        if(mqMessageListenerConfig != null){
//            System.out.println("topic:" + mqMessageListenerConfig.topic());
//            System.out.println("group:" + mqMessageListenerConfig.consumerGroup());
//        }
//        // 获取所有该注解的属性值
//        Iterator iterator = annotations.entrySet().iterator();
//        while (iterator.hasNext()){
//            Map.Entry entry = (Map.Entry) iterator.next();
//            Object object = entry.getValue();
//            MqMessageListenerConfig mqMessageListenerConfig1 = AnnotationUtils.findAnnotation(object.getClass(),MqMessageListenerConfig.class);
//            System.out.println(entry.getKey());
//            if(mqMessageListenerConfig1 != null){
//                System.out.println("topic:"+mqMessageListenerConfig1.topic()+ "     group:"+mqMessageListenerConfig1.consumerGroup());
//            }
//        }
    }
}
