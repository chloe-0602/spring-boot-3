package com.chloe.message;

import com.chloe.message.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
@Slf4j
@SpringBootTest
class Boot312MessageStuApplicationTests {

    @Autowired
    private KafkaTemplate kafkaTemplate;
    String newsTopic = "news";

    @Test
    public void testKafkaSend(){
        CompletableFuture future = kafkaTemplate.send(newsTopic, "hhh1", "hhhh value 1");
        future.join();
        log.info("信息发送成功......");
    }

    @Test
    public void testKafka1w(){
        CompletableFuture[] futures = new CompletableFuture[10000];

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            CompletableFuture future = kafkaTemplate.send(newsTopic, "msg"+i, "value" + i);
            futures[i] = future;
        }

        CompletableFuture.allOf(futures).join();
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();

        //956 ms
        log.info("发送1w条消息成功,耗时: {} ms", totalTimeMillis);
    }

    @Test
    public void testSendPerson(){
        CompletableFuture future = kafkaTemplate.send(newsTopic, "person", new Person(1L, "张三", "1323@qq.com"));
        future.join();
        log.info("person 发送成功......");
    }

}
