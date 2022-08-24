package com.melck.mckthymeleaf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.melck.mckthymeleaf.models.client.Client;
import com.melck.mckthymeleaf.models.enums.Gender;
import com.melck.mckthymeleaf.services.ClientService;

@Controller
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/client")
    public ModelAndView cadastroClient(){
        ModelAndView mv = new ModelAndView("cadastro-cliente");
        mv.addObject("gender", Gender.values());
        return mv;
    }

    @PostMapping ("/client")
    public String create(Client client){
        service.insert(client);
        return "redirect:/home";
    }



}
