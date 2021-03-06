package com.pangu.Controller;

import com.pangu.Http.response.RestResult;
import com.pangu.Mq.consumer.MqMessageListenerConfig;
import com.pangu.Mq.consumer.MqMessageListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.stereotype.Component;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-21 19:41
 * @desc mq消费测试类
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
//@MqMessageListenerConfig(topic = "pangu", consumerGroup = "zero")
//@Component
//public class MqListenerController implements MqMessageListener {
//
//    @Override
//    public RestResult exec(ConsumerRecord<String, String> record) {
//        System.out.println("===========record:" + record.toString());
//        return RestResult.successResult(record);
//    }
//}
