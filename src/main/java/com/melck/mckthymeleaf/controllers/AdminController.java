package com.melck.mckthymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.melck.mckthymeleaf.services.UserService;


@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private UserService service;

    
    @GetMapping
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("/clients/clientsList");
        mv.addObject("listClients", service.findAll());
        return mv;
    }


    @DeleteMapping("/delete/{id}")
    public ModelAndView removeUser(@PathVariable Long id) {
        service.delete(id);
        return new ModelAndView("redirect:/admins");
    }
}
