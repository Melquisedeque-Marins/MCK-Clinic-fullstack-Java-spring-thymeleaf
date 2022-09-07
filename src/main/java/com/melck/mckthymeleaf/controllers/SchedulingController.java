package com.melck.mckthymeleaf.controllers;

import com.melck.mckthymeleaf.dtos.SchedulingDTO;
import com.melck.mckthymeleaf.services.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/schedulings")
public class SchedulingController {

    @Autowired
    private SchedulingService service;

    @GetMapping("/form")
    public ModelAndView formScheduling(SchedulingDTO schedulingDTO) {
        ModelAndView mv = new ModelAndView("scheduling");
        return mv;
    }

    @PostMapping("/new")
    public ModelAndView newScheduling(SchedulingDTO schedulingDTO) {
       
        service.insert(schedulingDTO);
        return new ModelAndView("redirect:/users/logged");
    }


    
}
