package com.melck.mckthymeleaf.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

    public String home(){
        return "index";
    }
}
