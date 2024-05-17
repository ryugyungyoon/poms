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
/*
    @PostMapping("login")
    @ResponseBody
    public String User(Model model, CustomUserDetails userDetails){

        log.debug("로그인 정보 : {}",userDetails);

        if(userDetails != null){
            User loginUser = userService.getLoginUserById(userDetails.getUsername());
            if(loginUser != null){
                model.addAttribute("name", loginUser.getName());
            }
        }
        return "main";
    }

 */
/*
    @GetMapping("login")
    public String User(Model model, PrincipalDetails principal){
        log.debug("auth {}",principal);
        if(principal != null){
            User loginUser = userService.getLoginUserById(principal.getUsername());
            if(loginUser != null){
                model.addAttribute("name", loginUser.getName());
            }
        }
        return "main";
    }
*/

    /**
     * [로그인 성공후 이동]
     *
     * @author zisooya
     * @return String
     */
    /*
    @GetMapping("login-success")
    public String loginSuccess(){
        return "redirect:/main";
    }
*/

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
