package com.pangu.Redis;

import com.pangu.Base.Context.PanguApplicationContext;
import com.pangu.PanguApplication;
import redis.clients.jedis.Jedis;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-27 16:38
 * @desc: redis读取辅助类
 */
public class RedisUtil {

    private static Jedis jedis = PanguApplicationContext.getBean("jedisResource");

    public static void set(String key, String value) {
        jedis.set(key,value);
    }

    /**
     * 设置键值对并设置过期时间
     * @param key
     * @param seconds
     * @param value
     */
    public static void setex(String key, int seconds, String value){
        jedis.setex(key,seconds,value);
    }

    public static String get(String key){
        return jedis.get(key);
    }

    /**
     * 设置key的过期时间
     * @param key
     * @param seconds
     * @return
     */
    public static Long setKeyExpire(String key, int seconds){
        return jedis.expire(key, seconds);
    }

    public static Boolean setIfAbsent(String key, String value){
        if(jedis.exists(key)){
            return false;
        } else {
            jedis.set(key, value);
            return true;
        }
    }

    /**
     * 如果key存在则返回false，否则set
     * @param key
     * @param seconds
     * @param value
     * @return
     */
    public static Boolean setIfAbsent(String key, int seconds, String value){
        if(jedis.exists(key)){
            return false;
        } else {
            jedis.setex(key, seconds, value);
            return true;
        }
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public static Boolean delKey(String key){
        if(jedis.exists(key)){
            return jedis.del(key) == 1L;
        }
        return false;
    }
}
