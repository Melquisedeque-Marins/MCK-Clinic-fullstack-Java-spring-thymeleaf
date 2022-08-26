package com.melck.mckthymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.melck.mckthymeleaf.dtos.UserDTO;
import com.melck.mckthymeleaf.models.enums.Gender;
import com.melck.mckthymeleaf.services.UserService;

import javax.validation.Valid;

@Controller
public class ClientController {

    @Autowired
    private UserService service;

    @GetMapping("/clients/form")
    public ModelAndView formClient(){
        ModelAndView mv = new ModelAndView("/clients/form_client");
        mv.addObject("gender", Gender.values());
        return mv;
    }

    @GetMapping("/clients/logged")
    public ModelAndView loggedArea(){
        ModelAndView mv = new ModelAndView("/clients/logged_area");
        return mv;
    }

    @GetMapping("/clients")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("/clients/clients");
        mv.addObject("listClients", service.findAll());
        return mv;
    }

    @PostMapping ("/clients/new")
    public ModelAndView insertClient(@Valid UserDTO dto){
        service.insert(dto);
        ModelAndView mv = new ModelAndView("redirect:/clients/login");
        return mv;
    }


}
