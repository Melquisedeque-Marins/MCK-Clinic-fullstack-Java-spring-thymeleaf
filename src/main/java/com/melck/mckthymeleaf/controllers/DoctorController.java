package com.melck.mckthymeleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.services.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @GetMapping
    public ModelAndView listDoctors(){
        ModelAndView mv = new ModelAndView("doctors");
        List<Doctor> doctors = service.findAll();
        mv.addObject("doctors", doctors);
        return mv;
    }

    @PostMapping 
    public ModelAndView findAll(){
        return new ModelAndView("redirect:/doctors");
    }


    
}
