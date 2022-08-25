package com.melck.mckthymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.melck.mckthymeleaf.dtos.ClientDTO;
import com.melck.mckthymeleaf.models.enums.Gender;
import com.melck.mckthymeleaf.services.ClientService;

@Controller
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/clients/form")
    public ModelAndView cadastroClient(){
        ModelAndView mv = new ModelAndView("/clients/form_client");
        mv.addObject("gender", Gender.values());
        return mv;
    }

    @PostMapping ("/clients/new")
    public String create(ClientDTO dto){
        service.insert(dto);
        return "redirect:/";
    }


}
