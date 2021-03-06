package com.pangu.Monitor.scheduled.annotation;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-23 20:11
 * @desc:
 */
public class MonitorAnnotation implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry){
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(Monitor.class.getName()));
        long start = System.currentTimeMillis();
        System.out.println("around time:" + start);
        System.out.println(attributes.toString());

    }
}
