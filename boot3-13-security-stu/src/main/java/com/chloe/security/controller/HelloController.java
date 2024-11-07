package com.chloe.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: HelloController
 * Package: com.chloe.security.controller
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/7 8:30
 * @Version 1.0
 */
@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello Spring Security!!!";
    }
}
