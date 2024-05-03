package com.jg.poms.controller.user;

import com.jg.poms.domain.user.User;
import com.jg.poms.dto.user.request.UserCreateRequest;
import com.jg.poms.dto.user.request.UserLoginRequest;
import com.jg.poms.service.UserService;
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

    @PostMapping("login")
    @ResponseBody
    public String User(UserLoginRequest request){
        //return userService.saveUser(request);
        System.out.println("로그인 아이디: "+ request.getId());
        return request.getId();
    }
    /**
     * [로그인 성공후 이동]
     *
     * @author zisooya
     * @return String
     */
    @GetMapping("login-success")
    public String loginSuccess(){
        return "redirect:/main";
    }

    /**
     * [로그인 실패후 이동]
     *
     * @author zisooya
     * @return String
     */
    @GetMapping("login-fail")
    public String loginFail(){
        return "nonlogin/login_form";
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
