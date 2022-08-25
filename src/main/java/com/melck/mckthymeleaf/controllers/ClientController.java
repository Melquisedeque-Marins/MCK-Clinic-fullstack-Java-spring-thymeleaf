package com.melck.mckthymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.melck.mckthymeleaf.dtos.ClientDTO;
import com.melck.mckthymeleaf.models.enums.Gender;
import com.melck.mckthymeleaf.services.ClientService;

import javax.validation.Valid;

@Controller
public class ClientController {

    @Autowired
    private ClientService service;

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

    @PostMapping ("/clients/new")
    public ModelAndView insertClient(@Valid ClientDTO dto){
        service.insert(dto);
        ModelAndView mv = new ModelAndView("redirect:/clients/login");
        return mv;
    }


}
