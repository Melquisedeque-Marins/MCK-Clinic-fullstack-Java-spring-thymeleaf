package com.melck.mckthymeleaf.controllers;

import com.melck.mckthymeleaf.dtos.SchedulingDTO;
import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.models.doctor.Expertise;
import com.melck.mckthymeleaf.repositories.DoctorRepository;
import com.melck.mckthymeleaf.repositories.ExpertiseRepository;
import com.melck.mckthymeleaf.services.ExpertiseService;
import com.melck.mckthymeleaf.services.SchedulingService;

import java.util.List;

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

    @Autowired 
    private ExpertiseService expertiseService;


    @Autowired
    private DoctorRepository doctorRepository;

    @GetMapping("/form")
    public ModelAndView formScheduling(SchedulingDTO schedulingDTO, Expertise expertise) {
        ModelAndView mv = new ModelAndView("scheduling");
        List<Expertise> expertises = expertiseService.findAll();
        mv.addObject("expertises", expertises);
        mv.addObject(new Expertise());
        
        //  Expertise exp = expertiseService.findById(1L);
        //List<Doctor> doctors = doctorRepository.findByExpertise(expertise);
        //mv.addObject("doctors", doctors);
        return mv;
    }

    




    @PostMapping("/new")
    public ModelAndView newScheduling(SchedulingDTO schedulingDTO) {
       
        service.insert(schedulingDTO);
        return new ModelAndView("redirect:/users/logged");
    }


    
}
