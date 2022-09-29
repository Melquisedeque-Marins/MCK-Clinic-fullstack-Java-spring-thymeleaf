package com.melck.mckthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView home (){
        ModelAndView mv = new ModelAndView("index");
        return mv;
    }

    @GetMapping("/contacts")
    public ModelAndView contacts (){
        ModelAndView mv = new ModelAndView("/pages/contacts");
        return mv;
    }


}
