package com.melck.mckthymeleaf.controllers;

import com.melck.mckthymeleaf.models.doctor.Expertise;
import com.melck.mckthymeleaf.services.ExpertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ExpertiseController {

    @Autowired
    private ExpertiseService service;

    @GetMapping("/expertises")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("/pages/expertisesList");
        List<Expertise> expertises = service.findAll();
        mv.addObject("listExpertises", expertises);
        return mv;
    }
}
