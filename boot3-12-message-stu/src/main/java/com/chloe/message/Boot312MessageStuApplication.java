package com.chloe.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

/**
 * @AutoConfiguration
 * @ConditionalOnClass(KafkaTemplate.class)
 * @EnableConfigurationProperties(KafkaProperties.class)
 * @Import({ KafkaAnnotationDrivenConfiguration.class, KafkaStreamsAnnotationDrivenConfiguration.class })
 *
 * 消费者也是从消费者工厂中来的
 *
 * 4、KafkaAdmin：维护主题等等
 * 5、如果没有创建主题thing，在第一次发消息的时候也可以创建
 * 6、监听器@KafkaListener
 */
@EnableKafka
@SpringBootApplication
public class Boot312MessageStuApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot312MessageStuApplication.class, args);
    }

}
