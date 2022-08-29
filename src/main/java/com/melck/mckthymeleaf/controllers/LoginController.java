package com.melck.mckthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView cadastroClient(String username, String password){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
}
