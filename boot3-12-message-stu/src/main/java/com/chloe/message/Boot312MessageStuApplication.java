package com.chloe.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @AutoConfiguration
 * @ConditionalOnClass(KafkaTemplate.class)
 * @EnableConfigurationProperties(KafkaProperties.class)
 * @Import({ KafkaAnnotationDrivenConfiguration.class, KafkaStreamsAnnotationDrivenConfiguration.class })
 *
 * 消费者也是从消费者工厂中来的
 *
 * 4、KafkaAdmin：维护主题等等
 */
@SpringBootApplication
public class Boot312MessageStuApplication {

    public static void main(String[] args) {
        SpringApplication.run(Boot312MessageStuApplication.class, args);
    }

}
