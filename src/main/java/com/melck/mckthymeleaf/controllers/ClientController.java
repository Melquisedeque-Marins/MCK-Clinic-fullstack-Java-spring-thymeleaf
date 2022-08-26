package com.melck.mckthymeleaf.controllers;


import org.aspectj.internal.lang.annotation.ajcDeclareEoW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.melck.mckthymeleaf.dtos.UserDTO;
import com.melck.mckthymeleaf.models.client.User;
import com.melck.mckthymeleaf.models.enums.Gender;
import com.melck.mckthymeleaf.services.UserService;

import javax.servlet.http.HttpSession;
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
    
    @PostMapping ("/clients/form")
    public ModelAndView insertClient(@Valid UserDTO dto){
        service.insert(dto);
        ModelAndView mv = new ModelAndView("redirect:/clients/login");
        return mv;
    }

    
    @GetMapping("/clients")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("/clients/clients");
        mv.addObject("listClients", service.findAll());
        return mv;
    }
    
    
    @GetMapping("/clients/login")
    public ModelAndView cadastroClient(String cpf, String password){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @PostMapping("/login")
    public String login(User login, HttpSession session){
        User user = service.login(login.getCpf(), login.getPassword());
        session.setAttribute("LoggedUser", user);
        return "redirect:/clients/logged";
    }
    
    @GetMapping("/clients/logged")
    public ModelAndView loggedArea(User LoggedUser){
        ModelAndView mv = new ModelAndView("/clients/logged_area");
        return mv;
    }

}
