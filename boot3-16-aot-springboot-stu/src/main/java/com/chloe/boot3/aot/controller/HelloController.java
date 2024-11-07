package com.chloe.boot3.aot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Package: com.chloe.boot3.aot.controller
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/7 23:30
 * @Version 1.0
 */
@RestController
public class HelloController {
    @RequestMapping("/")
    public String hello(){
        return "Hello, Spring Boot AOT!!!";
    }
}
