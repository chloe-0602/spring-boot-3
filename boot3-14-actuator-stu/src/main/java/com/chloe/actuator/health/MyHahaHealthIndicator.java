package com.chloe.actuator.health;

import com.chloe.actuator.component.MyHahaComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: MyHahaHealthIndicator
 * Package: com.chloe.actuator.health
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/7 10:52
 * @Version 1.0
 */
@Component
public class MyHahaHealthIndicator extends AbstractHealthIndicator {
    @Autowired
    MyHahaComponent myHahaComponent;
    @Override
    protected void doHealthCheck(Health.Builder builder) throws Exception {
        Integer check = myHahaComponent.check();

        Map<String, Object> details = new HashMap();


        if(1 == check){
            details.put("code", 1000);
            details.put("message", "this is haha");

            builder.up()
                    .withDetails(details)
                    .build();
        }else {
            details.put("code", 1001);
            details.put("message", "this is haha down");

            builder.down()
                    .withDetails(details)
                    .build();
        }
    }
}
