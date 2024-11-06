package com.chloe.message.listener;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.PartitionOffset;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * ClassName: KafkaListener
 * Package: com.chloe.message.listener
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/6 23:40
 * @Version 1.0
 */
@Slf4j
@Component
public class MyKafkaListener {
    //默认是监听新的消息
    @KafkaListener(groupId = "group1", topics = "news")
    public void listen(ConsumerRecord consumerRecord){
        Object key = consumerRecord.key();
        Object value = consumerRecord.value();
        log.info("group1 监听器，监听到：key => {}, value: {}", key, value);
    }

    // 从某个offset开始监听消息，消费历史信息
    @KafkaListener(groupId = "group2", topicPartitions = {
            @TopicPartition(topic = "news", partitionOffsets = {
                    @PartitionOffset(partition = "0", initialOffset = "10000")
            })
    })
    public void newsListen(ConsumerRecord consumerRecord){
        Object key = consumerRecord.key();
        Object value = consumerRecord.value();
        log.info("group2 监听器，监听到：key => {}, value: {}", key, value);
    }
}
