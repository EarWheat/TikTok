package com.pangu.Redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020/12/30 下午5:00
 * @desc redis配置类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
@Data
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
    public String host;
    public String port;
    public String password;
    public String timeout;
    public Map<String, JedisPoolConfiguration> jedis;
    public boolean open = false;

    @Data
    public static class JedisPoolConfiguration {
        private int maxActive;
        private int maxWait;
        private int maxIdle;
        private int minIdle;
    }

}
