package com.jg.poms.controller.user;

import com.jg.poms.domain.user.User;
import com.jg.poms.dto.user.request.UserCreateRequest;
import com.jg.poms.service.user.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Slf4j
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("login-form")
    public String loginForm(){
        return "nonlogin/login-form";
    }

    @GetMapping("terms-form")
    public String termsForm(){
        return "user/terms";
    }

    @GetMapping("join-form")
    public String joinForm(){
        return "user/join";
    }

    @PostMapping("save-user")
    @ResponseBody
    public User saveUser(UserCreateRequest request){
        return userService.saveUser(request);
    }

    @PostMapping("certify")
    @ResponseBody
    public String certify(@RequestParam("contactNumber") String contactNumber){
        log.debug(contactNumber);
        return userService.certify(contactNumber);
    }
}
