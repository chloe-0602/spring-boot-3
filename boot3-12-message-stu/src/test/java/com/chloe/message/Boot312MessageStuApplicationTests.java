package com.chloe.message;

import lombok.extern.slf4j.Slf4j;
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
    @Test
    public void testKafkaSend(){
        String topic = "news";
        CompletableFuture future = kafkaTemplate.send(topic, "hhh1", "hhhh value 1");
        future.join();
        log.info("信息发送成功......");
    }

    @Test
    public void testKafka1w(){
        String topic = "news";
        CompletableFuture[] futures = new CompletableFuture[10000];

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10000; i++) {
            CompletableFuture future = kafkaTemplate.send(topic, "msg"+i, "value" + i);
            futures[i] = future;
        }

        CompletableFuture.allOf(futures).join();
        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();

        //956 ms
        log.info("发送1w条消息成功,耗时: {} ms", totalTimeMillis);
    }




}
