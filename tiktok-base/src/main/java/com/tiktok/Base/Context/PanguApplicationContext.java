package com.tiktok.Base.Context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2021/1/2 下午3:18
 * @desc 盘古项目上下文类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Component
@Order(-10001)
public class PanguApplicationContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public PanguApplicationContext(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        PanguApplicationContext.applicationContext = applicationContext;
    }

    /**
     * 获取一个ApplicationContext.
     *
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 根据名称获取一个对象.
     *
     * @param name bean名称
     * @return Object 指定的bean
     * @throws BeansException 如果找不到bean
     */
    public static <T> T getBean(String name) throws BeansException {
        return (T) applicationContext.getBean(name);
    }
}
