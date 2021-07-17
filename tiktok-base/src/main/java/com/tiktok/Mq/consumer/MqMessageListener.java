package com.tiktok.Mq.consumer;

import com.tiktok.Http.response.RestResult;
import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-18 18:18
 * @desc
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public interface MqMessageListener {
    RestResult exec(ConsumerRecord<String, String> record);
}
