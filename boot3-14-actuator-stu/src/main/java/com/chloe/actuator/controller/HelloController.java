package com.chloe.actuator.controller;

import com.chloe.actuator.component.MyHahaComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Package: com.chloe.actuator.controller
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/7 11:45
 * @Version 1.0
 */
@RestController
public class HelloController {
    @Autowired
    private MyHahaComponent myHahaComponent;

    @GetMapping("/hello")
    public void hello(){
        myHahaComponent.hello();
    }
}
