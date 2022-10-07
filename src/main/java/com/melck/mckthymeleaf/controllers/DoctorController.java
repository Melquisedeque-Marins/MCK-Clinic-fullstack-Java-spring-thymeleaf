package com.melck.mckthymeleaf.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.services.DoctorService;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    /* 
    @GetMapping
    public ModelAndView listDoctors(){
        ModelAndView mv = new ModelAndView("doctors");
        List<Doctor> doctors = service.findAll();
        mv.addObject("doctors", doctors);
        return mv;
    }
    */

    @GetMapping
	public ModelAndView findAllDoctorsPaged(
			@RequestParam(value = "expertiseId", defaultValue = "0") Long expertiseId,
			@RequestParam(value = "name", defaultValue = "") String name,
			Pageable pageable
	) {
		Page<Doctor> page = service.findAllPaged(expertiseId, name.trim(), pageable);
        ModelAndView mv = new ModelAndView("doctors");
        mv.addObject("doctors", page);
        return mv;
	}

    @PostMapping 
    public ModelAndView findAll(){
        return new ModelAndView("redirect:/doctors");
    }


    
}
