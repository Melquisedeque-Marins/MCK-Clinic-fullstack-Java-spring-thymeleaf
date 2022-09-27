package com.melck.mckthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AboutController {

    @GetMapping("/about")
    public ModelAndView about() {
        ModelAndView mv = new ModelAndView("/pages/about");
        return mv;
    }
}
