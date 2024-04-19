package com.jg.poms.controller.user;

import com.jg.poms.domain.user.User;
import com.jg.poms.dto.user.request.UserCreateRequest;
import com.jg.poms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

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

    @PostMapping("/save-user")
    @ResponseBody
    public User saveUser(UserCreateRequest request){
        return userService.saveUser(request);
    }
}
