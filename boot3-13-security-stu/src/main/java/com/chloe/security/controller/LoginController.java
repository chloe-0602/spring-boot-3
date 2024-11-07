package com.chloe.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName: LoginController
 * Package: com.chloe.security.controller
 * Description:
 *
 * @Author Xu, Luqin
 * @Create 2024/11/7 8:27
 * @Version 1.0
 */
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
