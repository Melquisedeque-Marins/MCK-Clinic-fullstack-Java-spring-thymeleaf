package com.melck.mckthymeleaf.controllers;


import com.melck.mckthymeleaf.dtos.UserDTO;
import com.melck.mckthymeleaf.models.enums.Gender;
import com.melck.mckthymeleaf.models.user.User;
import com.melck.mckthymeleaf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ClientController {
    
    @Autowired
    private UserService service;

    
    @GetMapping("/clients/form")
    public ModelAndView formClient(UserDTO userDTO){
        ModelAndView mv = new ModelAndView("/clients/formClient");
        mv.addObject("listGender", Gender.values());
        return mv;
    }
    
    @PostMapping ("/clients/form")
    public ModelAndView insertClient(@Valid UserDTO userDTO, BindingResult br){
        if (br.hasErrors()){
            ModelAndView mv = new ModelAndView("/clients/formClient");
            mv.addObject("listGender", Gender.values());
            return mv;
        }
        service.insert(userDTO);
        return new ModelAndView("redirect:/login");
    }

    
    @GetMapping("/clients")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("/clients/clients");
        mv.addObject("listClients", service.findAll());
        return mv;
    }

    @GetMapping("/login")
    public ModelAndView cadastroClient(String username, String password){
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }
    
    @GetMapping("/clients/logged")
    public ModelAndView loggedArea(){
        ModelAndView mv = new ModelAndView("/clients/logged_area");
        User user = service.userLogged();
        mv.addObject("userLogged", user);
        return mv;
    }

}
