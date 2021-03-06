package com.pangu.Mq.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.util.Collections;
import java.util.Properties;

/**
 * @author liuzhaoluliuzhaolu
 * @date 2020-12-23 20:11
 * @desc 多线程执行消费
 * @prd
 * @Modification History:
 * Date         Author          Description
 * ------------------------------------------ *
 */
public class MqMessageConsumerRunnable implements Runnable{

    private final KafkaConsumer<String, String> consumer;
    private ConsumerRecords<String, String> msgList;
    private final String topic;
    private MqMessageListener mqMessageListener;

    public MqMessageConsumerRunnable(MqMessageProperties mqMessageProperties, MqMessageListener mqMessageListener) {
        Properties props = new Properties();
        props.put("bootstrap.servers", mqMessageProperties.getServers());
        props.put("group.id", mqMessageProperties.getGroup());
        props.put("enable.auto.commit", mqMessageProperties.getAutoCommit());
        props.put("auto.commit.interval.ms", mqMessageProperties.getAutoCommitInterval());
        props.put("session.timeout.ms", mqMessageProperties.getSessionTimeOut());
        props.put("auto.offset.reset", mqMessageProperties.getAutoOffsetReset());
        props.put("key.deserializer", StringDeserializer.class.getName());
        props.put("value.deserializer", StringDeserializer.class.getName());
        this.consumer = new KafkaConsumer<String, String>(props);
        this.topic = mqMessageProperties.getTopic();
        this.consumer.subscribe(Collections.singletonList(topic));
        this.mqMessageListener = mqMessageListener;
    }

    @Override
    public void run() {
        try {
            while (true){
                System.out.println(Thread.currentThread().getName() + " is Listen");
                msgList = consumer.poll(1000);
                if(null != msgList && msgList.count() > 0){
                    for (ConsumerRecord<String, String> record : msgList) {
                        System.out.println(Thread.currentThread().getName() + " consumer:" + record);
                        mqMessageListener.exec(record);
                    }
                }else{
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            consumer.close();
        }
    }
}
