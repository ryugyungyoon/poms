package com.jg.poms.controller.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/terms-form")
    public String index(){
        return "redirect:/terms-form";
    }
}
