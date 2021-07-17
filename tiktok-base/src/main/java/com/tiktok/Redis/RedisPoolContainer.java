package com.tiktok.Redis;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020/12/30 下午5:16
 * @desc redis连接池
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class RedisPoolContainer {
    private static final Logger logger = LoggerFactory.getLogger(RedisPoolContainer.class);

    private JedisPool jedisPool = null;

    @Resource
    private RedisProperties redisProperties;

    @Bean
    public JedisPool redisPoolFactory(){
        try {
            String host = redisProperties.getHost();
            int port = Integer.parseInt(redisProperties.getPort());
            int timeout = Integer.parseInt(redisProperties.getTimeout());
            String password = redisProperties.getPassword();
            Map<String, RedisProperties.JedisPoolConfiguration> map = redisProperties.getJedis();
            RedisProperties.JedisPoolConfiguration jedisPoolConfiguration = map.get("pool");
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(jedisPoolConfiguration.getMaxIdle());
            jedisPoolConfig.setMaxWaitMillis(jedisPoolConfiguration.getMaxWait());
            if(StringUtils.isNotBlank(password)){
                jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, password);
            } else {
                jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout);
            }
        } catch (Exception e) {
            logger.error("Jedis pool initialize error:" + e);
        }
        return jedisPool;
    }

    @Bean(name = "jedisResource")
    public Jedis jedisResource(){
        Jedis jedis = null;
        try {
            if(jedisPool == null){
                jedisPool = redisPoolFactory();
            }
            jedis = jedisPool.getResource();
        } catch (Exception e){
            logger.error("Redis start Error: {}", e.toString());
        }
        return jedis;
    }

}
