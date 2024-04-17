package com.jg.poms.controller.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/login-form")
    public String loginForm(){
        return "";
    }

    @GetMapping("/terms-form")
    public String termsForm(){
        return "user/terms";
    }

    @GetMapping("/join-form")
    public String joinForm(){
        return "user/join";
    }
}
