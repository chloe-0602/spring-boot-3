package com.chloe.actuator.component;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ClassName: HahaComponent
 * Package: com.chloe.actuator.component
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/7 10:53
 * @Version 1.0
 */
@Component
@Slf4j
public class MyHahaComponent {
    Counter counter = null;

    public MyHahaComponent(MeterRegistry meterRegistry) {
        counter = meterRegistry.counter("myhaha.count");
    }

    public Integer check() {
        return 1;
    }

    public void hello(){
        counter.increment();
        log.info("hello......");
    }

}
