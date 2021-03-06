package com.pangu.Controller;

import com.alibaba.fastjson.JSONObject;
import com.pangu.Base.Context.PanguApplicationContext;
import com.pangu.Http.request.HttpClient;
import com.pangu.Http.response.RestResult;
import com.pangu.Monitor.Http.HttpMonitor;
import com.pangu.Redis.RedisUtil;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-12 18:27
 * @desc:
 */
@org.springframework.web.bind.annotation.RestController
@SpringBootApplication
public class RestController {

    @HttpMonitor
    @RequestMapping(value = "/test")
    public RestResult<JSONObject> restInfo() throws InterruptedException {
        ApplicationContext context = PanguApplicationContext.getApplicationContext();
        String[] beans = context.getBeanDefinitionNames();
        for (String beanName:beans){
            System.out.println(beanName);
        }
        JedisPool jedisPool = PanguApplicationContext.getBean("redisPoolFactory");
        Jedis jedis = jedisPool.getResource();
        jedis.set("hello","zero");
        System.out.println("=========================" + jedis.get("hello"));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("extra",jedis.get("hello"));
        RedisUtil.set("redis","Test redisUtil");
        jsonObject.put("redis", RedisUtil.get("redis"));
        return RestResult.successResult(jsonObject);
    }

    @RequestMapping(value = "/kefu")
    public RestResult<String> kefu() throws Exception {
        String url = "xxxxxxx";
        JSONObject object = new JSONObject();
        object.put("order_id","87969391989219");
        object.put("district","03035");
        object.put("requester_type",2);
        object.put("lang","ex-MX");
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Type", "appliction/json");
        String object1 = HttpClient.doPostJsonHttp(url,object, httpHeaders, 3000,3000);
        return RestResult.successResult(object1);
    }


}
