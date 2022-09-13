package com.melck.mckthymeleaf.services;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.melck.mckthymeleaf.dtos.SchedulingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.melck.mckthymeleaf.models.Scheduling;
import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.models.enums.OfficeHours;
import com.melck.mckthymeleaf.models.enums.Status;
import com.melck.mckthymeleaf.models.enums.Type;
import com.melck.mckthymeleaf.models.user.User;
import com.melck.mckthymeleaf.repositories.DoctorRepository;
import com.melck.mckthymeleaf.repositories.SchedulingRepository;
import com.melck.mckthymeleaf.repositories.UserRepository;
import com.melck.mckthymeleaf.services.exceptions.ResourceNotFoundException;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

   
    @Autowired
    private AuthService authService;


   @Transactional
    public Scheduling insert(SchedulingDTO dto){
        User user = authService.authenticated();
        dto.setUserId(user.getId());
        Scheduling scheduling = toScheduling(dto);

        scheduling.setSchedulingTime(LocalDateTime.parse(dto.getSchedulingTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
        scheduling.setStatus(Status.SCHEDULED);
        scheduling.setType(Type.CONSULT);
        return repository.save(scheduling);
    }

    @Transactional(readOnly = true)
    public Scheduling findById(Long id){
        Optional<Scheduling> opt = repository.findById(id);
        Scheduling scheduling = opt.orElseThrow(() -> new ResourceNotFoundException("Resource not found"));
        authService.validateSelfOrAdmin(scheduling.getUser().getId());
        return scheduling;

    }

    @Transactional(readOnly = true)
    public List<Scheduling> findAll(){
        List<Scheduling> schedulings = repository.findAll();
        return schedulings;
    }

    @Transactional
    public Page<Scheduling> findAllByUser(Pageable pageable) {
        User user = authService.authenticated();
        List<User> users = Arrays.asList(userRepository.getReferenceById(user.getId()));
        Page<Scheduling> schedulings = repository.find(users, pageable);
        return schedulings;
    }

    public Scheduling toScheduling(SchedulingDTO dto){
        User user = userRepository.getReferenceById(dto.getUserId());
        Doctor doctor = doctorRepository.getReferenceById(dto.getDoctorId());
        Scheduling scheduling = new Scheduling();
        scheduling.setUser(user);
        scheduling.setDoctor(doctor);
        return scheduling;
    }

    public List<Scheduling> findByDoctor(Doctor doctor){
        List<Scheduling> schedulings = repository.findByDoctor(doctor);
         return schedulings;
    } 


    @Transactional
    public List<LocalTime> findFreeSchedules(Long doctorId){
        Doctor doctor = doctorRepository.getReferenceById(doctorId);
       
        List<LocalDateTime> schedules = new ArrayList<>();
      // for (LocalDateTime toDay = LocalDateTime.of(LocalDate.now(), LocalTime.of(07, 00, 00)); toDay.isBefore(toDay.plusHours(1)); toDay.plusMinutes(10)){
        for (int i = 0; i < 360; i=i+10) {
            LocalDateTime toDay = LocalDateTime.of(LocalDate.now(), LocalTime.of(07, 00, 00));
            schedules.add(toDay.plusMinutes(i));
        }
        
        List<Scheduling> schedulings = repository.findBySchedule(schedules, doctor);

        if (schedulings.isEmpty()) {
            return schedules.stream().map(sch -> sch.toLocalTime()).collect(Collectors.toList());
        }else {
        List<LocalDateTime> freeSchedules = new ArrayList<>();
        for (Scheduling scheduling : schedulings){
            for (int i =0; i < schedules.size(); i++){
                if (!scheduling.getSchedulingTime().equals(schedules.get(i))){
                    freeSchedules.add(schedules.get(i));
                }
            }
        }
        
        return freeSchedules.stream().map(sch -> sch.toLocalTime()).collect(Collectors.toList());
    }
    }
}
