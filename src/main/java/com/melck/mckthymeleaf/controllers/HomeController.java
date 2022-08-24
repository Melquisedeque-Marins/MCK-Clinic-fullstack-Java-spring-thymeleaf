package com.melck.mckthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView ModelAndView (){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("nome", "deu certo");
        return mv;
    }

}
