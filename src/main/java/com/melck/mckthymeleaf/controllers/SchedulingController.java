package com.melck.mckthymeleaf.controllers;

import com.melck.mckthymeleaf.dtos.SchedulingDTO;
import com.melck.mckthymeleaf.models.Scheduling;
import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.models.doctor.Expertise;
import com.melck.mckthymeleaf.repositories.DoctorRepository;
import com.melck.mckthymeleaf.repositories.ExpertiseRepository;
import com.melck.mckthymeleaf.services.DoctorService;
import com.melck.mckthymeleaf.services.ExpertiseService;
import com.melck.mckthymeleaf.services.SchedulingService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ModelAndView scheduling(SchedulingDTO schedulingDTO, Expertise expertise) {
        ModelAndView mv = new ModelAndView("schedulings");
        List<Expertise> expertises = expertiseService.findAll();
        List<Doctor> doctors = doctorService.findAll();
        mv.addObject("expertises", expertises);
        mv.addObject(new Expertise());
        mv.addObject("doctors", doctors);
        return mv;
    }

    @GetMapping("/form")
    public ModelAndView formScheduling(SchedulingDTO schedulingDTO, Expertise expertise) {
        ModelAndView mv = new ModelAndView("schedulingForm");
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
        return new ModelAndView("redirect:/users");
    }

    @GetMapping("/expertises/{id}/doctors")
    public ModelAndView doctorsPerExpertise(@PathVariable long id){
        ModelAndView mv = new ModelAndView("/pages/expertise");
        Expertise expertise = expertiseService.findById(id);
        List<Doctor> doctors = doctorRepository.findByExpertise(expertise);
        mv.addObject("doctors", doctors);
        mv.addObject("expertise", expertise);
        return mv;
    }

    @GetMapping("/expertises/{expertiseId}/doctors/{doctorId}")
    public ModelAndView doctorSchedule(@PathVariable Long expertiseId, @PathVariable Long doctorId, SchedulingDTO schedulingDTO){
        Expertise expertise = expertiseService.findById(expertiseId);
        Doctor doctor = doctorService.findById(doctorId);
        System.out.println(schedulingDTO.getSchedulingDate());

        LocalDate localDate = LocalDate.now();//For reference
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (schedulingDTO.getSchedulingDate() == null ){
            schedulingDTO.setSchedulingDate(localDate.format(formatter));
        }
        List<String> freeSchedules = service.findFreeSchedules(doctorId, schedulingDTO.getSchedulingDate());
       
        ModelAndView mv = new ModelAndView("/pages/doctorSchedules");
        mv.addObject("date", schedulingDTO.getSchedulingDate());
        mv.addObject("freeSchedules", freeSchedules);
        mv.addObject("expertise", expertise);
        mv.addObject("doctor", doctor);
        return mv;
    }

    @GetMapping("/expertises")
    public ModelAndView expertises(){
        ModelAndView mv = new ModelAndView("/pages/expertisesList");
        List<Expertise> expertises = expertiseService.findAll();
        mv.addObject("expertisesList", expertises);
        return mv;
    }

    /* 
    @GetMapping("/doctors")
    public ModelAndView doctors(){
        ModelAndView mv = new ModelAndView("/pages/doctorsList");
        List<Doctor> doctors = doctorService.findAll();
        List<Expertise> expertises = expertiseService.findAll();
        mv.addObject("expertisesList", expertises);
        mv.addObject("doctorsList", doctors);
        return mv;
    }
    */

    @GetMapping("/doctors")
	public ModelAndView findAllDoctorsPaged(
			@RequestParam(value = "expertiseId", defaultValue = "0") Long expertiseId,
			@RequestParam(value = "name", defaultValue = "") String name,
			Pageable pageable
	) {
		Page<Doctor> page = doctorService.findAllPaged(expertiseId, name.trim(), pageable);
        ModelAndView mv = new ModelAndView("/pages/doctorsList");
        List<Expertise> expertises = expertiseService.findAll();
        mv.addObject("expertisesList", expertises);
        mv.addObject("doctorsList", page);
        return mv;
	}

    @PutMapping("/canceleds")
    public ModelAndView setCanceledStatus (){
        service.setCanceledStatus();
        return new ModelAndView("redirect:/admins/doctors");
    }


}
