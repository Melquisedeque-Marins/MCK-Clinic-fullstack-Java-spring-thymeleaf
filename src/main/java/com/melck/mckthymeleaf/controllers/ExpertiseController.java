package com.melck.mckthymeleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.models.doctor.Expertise;
import com.melck.mckthymeleaf.repositories.DoctorRepository;
import com.melck.mckthymeleaf.services.ExpertiseService;

@Controller
@RequestMapping("/expertises")
public class ExpertiseController {

    @Autowired
    private ExpertiseService service;

    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView("/pages/expertisesList");
        List<Expertise> expertises = service.findAll();
        mv.addObject("listExpertises", expertises);
        return mv;
    }

    @GetMapping("/{id}/doctors")
    public ModelAndView findById(@PathVariable long id){
        ModelAndView mv = new ModelAndView("/pages/expertise");
        Expertise expertise = service.findById(id);
        List<Doctor> doctors = doctorRepository.findByExpertise(expertise);
        mv.addObject("doctors", doctors);
        mv.addObject("expertise", expertise);
        return mv;
    }
}
