package com.pangu;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tiktok.Http.response.RestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * @author:liuzhaolu
 * @createTime: 2019-12-19 16:24
 * @desc:
 */
class PanguTest {

    private static final Logger logger = LoggerFactory.getLogger(PanguTest.class);

    @org.junit.jupiter.api.Test
    void testSuccess() {
        JSONObject object = JSON.parseObject("{\"errno\":0,\"errmsg\":\"SUCCESS\",\"data\":\"hello\"}");
        RestResult restFulResult1 = RestResult.successResult(object);
        System.out.println(JSONObject.toJSONString(restFulResult1));
        logger.info(JSONObject.toJSONString(restFulResult1));
        RestResult restFulResult2 = RestResult.failResult(10000,"ERROR","Test EXCEPTION");
        System.out.println(JSONObject.toJSONString(restFulResult2));
        logger.info(JSONObject.toJSONString(restFulResult2));
    }
}