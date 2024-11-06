package com.chloe.message.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * ClassName: KafkaTopicConfig
 * Package: com.chloe.message.config
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/6 23:36
 * @Version 1.0
 */
@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("thing1")
                .partitions(1)
//                .replicas(3)
                .compact()
                .build();
    }
}
