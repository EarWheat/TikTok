package com.pangu.dataBaseTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * @author:liuzhaolu
 * @createTime: 2020-06-27 16:46
 * @desc:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    static Logger logger = LoggerFactory.getLogger(RedisTest.class);

    @Value("${spring.redis.host}")
    private String host;

    @Test
    public void test() throws InterruptedException {
        System.out.println("++++++++"+host);
        logger.info("++++++++"+host);
//        RedisUtil.set("hello","world");
//        System.out.println(RedisUtil.get("hello"));
    }
}
