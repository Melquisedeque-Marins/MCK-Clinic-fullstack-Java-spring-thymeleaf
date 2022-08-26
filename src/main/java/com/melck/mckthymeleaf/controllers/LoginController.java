package com.melck.mckthymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.melck.mckthymeleaf.services.UserService;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;


    @GetMapping("/clients/login")
    public ModelAndView cadastroClient(){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @PostMapping("/login")
    public String login(String cpf, String password){
        userService.login(cpf, password);

        return "redirect:/clients/logged";
    }

    
}
