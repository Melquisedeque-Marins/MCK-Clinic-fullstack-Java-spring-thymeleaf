package com.melck.mckthymeleaf.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/default")
public class DefaultController {

    @GetMapping
    public ModelAndView defaultSucessUrl(HttpServletRequest request){
        if (request.isUserInRole("ROLE_ADMIN")) {
            return new ModelAndView("redirect:/admins");
        }
        return new ModelAndView("redirect:/users/logged");
      
    }
    
}
