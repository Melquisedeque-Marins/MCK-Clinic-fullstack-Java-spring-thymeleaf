package com.melck.mckthymeleaf.services;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.melck.mckthymeleaf.dtos.SchedulingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.melck.mckthymeleaf.models.Scheduling;
import com.melck.mckthymeleaf.models.doctor.Doctor;
import com.melck.mckthymeleaf.models.enums.Status;
import com.melck.mckthymeleaf.models.enums.Type;
import com.melck.mckthymeleaf.models.user.User;
import com.melck.mckthymeleaf.repositories.DoctorRepository;
import com.melck.mckthymeleaf.repositories.SchedulingRepository;
import com.melck.mckthymeleaf.repositories.UserRepository;
import com.melck.mckthymeleaf.services.exceptions.InvalidDateException;
import com.melck.mckthymeleaf.services.exceptions.ResourceNotFoundException;
import com.melck.mckthymeleaf.services.exceptions.UnauthorizedException;

@Service
public class SchedulingService {

    @Autowired
    private SchedulingRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private AuthService authService;


   @Transactional
    public Scheduling insert(SchedulingDTO dto){
        User user = authService.authenticated();
        if (user == null) {
            throw new UnauthorizedException("Faça o login para poder realizar seu agendamento");
        }
        if (dto.getUserId() == null){
            dto.setUserId(user.getId());
        }
        Scheduling scheduling = toScheduling(dto);
        scheduling.setSchedulingTime(LocalDateTime.parse(dto.getSchedulingTime(), DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm")));
        scheduling.setStatus(Status.SCHEDULED);
        scheduling.setType(Type.CONSULT);
        scheduling = repository.save(scheduling);
        emailService.sendEmailConfirmScheduling(user, scheduling);
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

    @Transactional
    public Page<Scheduling> findAllByUser(Long id, Pageable pageable) {
        List<User> users = Arrays.asList(userRepository.getReferenceById(id));
        Page<Scheduling> schedulings = repository.find(users, pageable);
        return schedulings;
    }

    
    public List<Scheduling> findByDoctor(Doctor doctor){
        List<Scheduling> schedulings = repository.findByDoctor(doctor);
        return schedulings;
    } 

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void updateStatus(Long id) {
        authService.validateSelfOrAdmin(id);
        Scheduling scheduling = repository.getReferenceById(id);
        if(scheduling.getSchedulingTime().plusHours(8).isBefore(LocalDateTime.now()) || scheduling.getStatus().equals(Status.CONFIRMED)){
            throw new InvalidDateException("this record cannot be updated, as it has already been");
        }
        scheduling.setStatus(Status.CONFIRMED);
        repository.save(scheduling);
    }

    //@PreAuthorize("hasRole('ROLE_ADMIN')")
    @Scheduled(cron = "0 0 12 * * *")
    @Scheduled(cron = "0 0 18 * * *")
    @Transactional
    public void cancelSchedulings() {
        List<Scheduling> scheduling = repository.findAll();
        for (Scheduling sch : scheduling) {
            if(sch.getSchedulingTime().plusHours(1).isBefore(LocalDateTime.of(LocalDate.now(), LocalTime.now())) && sch.getStatus().equals(Status.SCHEDULED)){
                sch.setStatus(Status.CANCELED);
                repository.save(sch); 
            }
            
        }
    }

    @Transactional
    public List<Scheduling> findSchedulesPerDoctor(Long doctorId){
        LocalDate date = LocalDate.now();
        LocalTime now = LocalTime.of(7, 0);
        List<LocalDateTime> schedules = new ArrayList<>();

        for (int i = 0; i < 720; i=i+10) {
            LocalDateTime toDay = LocalDateTime.of(date, now.truncatedTo(ChronoUnit.HOURS).plusMinutes(30 + (10 * (now.getMinute() / 10))));
            schedules.add(toDay.plusMinutes(i));
        }
          

        List<Scheduling> schedulings = repository.findBySchedule(schedules, doctorId);
    
        return schedulings;
    }


    
    @Transactional
    public List<String> findFreeSchedules(Long doctorId, String localDate){
        LocalDate date;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime now = LocalTime.now();
        Doctor doctor = doctorRepository.getReferenceById(doctorId);
        String officeHours = doctor.getOfficeHours().toString();
        if(localDate == null){
            date = LocalDate.now();
        }
        date = LocalDate.parse(localDate);

        List<LocalDateTime> schedules = new ArrayList<>();

        if (date.isBefore(LocalDate.now())){
            throw new ResourceNotFoundException("Não pode agendar no passado");
        }

        switch(officeHours){
            case "MORNING":
                if (date.compareTo(LocalDate.now()) == 0){
                    for (int i = 0; i < 310; i=i+10) {
                        LocalDateTime toDay = LocalDateTime.of(date, now.truncatedTo(ChronoUnit.HOURS).plusMinutes(30 + (10 * (now.getMinute() / 10))));
                        if (toDay.plusMinutes(i).isBefore(LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 10)))) 
                        schedules.add(toDay.plusMinutes(i));
                    }
                } else {
                    for (int i = 0; i < 310; i=i+10) {
                        LocalDateTime toDay = LocalDateTime.of(date, LocalTime.of(07, 00));
                        schedules.add(toDay.plusMinutes(i));
                    }
                }
            break;
            case "AFTERNOON":
                if (date.compareTo(LocalDate.now()) == 0){
                    for (int i = 0; i < 720; i=i+10) {
                        LocalDateTime toDay = LocalDateTime.of(date, now.truncatedTo(ChronoUnit.HOURS).plusMinutes(30 + (10 * (now.getMinute() / 10))));
                        if (toDay.plusMinutes(i).isAfter(LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 50))) && toDay.plusMinutes(i).isBefore(LocalDateTime.of(LocalDate.now(), LocalTime.of(18, 10))) ) 
                        schedules.add(toDay.plusMinutes(i));
                    }
                } else {
                    for (int i = 0; i < 310; i=i+10) {
                        LocalDateTime toDay = LocalDateTime.of(date, LocalTime.of(13, 00));
                        schedules.add(toDay.plusMinutes(i));
                    }
                }
            break;
            case "ALL_DAY":
                if (date.compareTo(LocalDate.now()) == 0){
                    for (int i = 0; i < 360; i=i+10) {
                        LocalDateTime toDay = LocalDateTime.of(date, now.truncatedTo(ChronoUnit.HOURS).plusMinutes(30 + (10 * (now.getMinute() / 10))));
                        schedules.add(toDay.plusMinutes(i));
                    }
                } else {
                    for (int i = 0; i < 720; i=i+10) {
                        LocalDateTime toDay = LocalDateTime.of(date, LocalTime.of(07, 00));
                        schedules.add(toDay.plusMinutes(i));
                    }
                }
            break;

        }

        List<LocalDateTime> schedulings = (repository.findBySchedule(schedules, doctorId)).stream().map(s -> s.getSchedulingTime()).collect(Collectors.toList());
        if (schedulings.isEmpty()) {
            return schedules.stream().map(sch -> formatter.format(sch)).collect(Collectors.toList());
        }
       
        schedules.removeAll(schedulings);
        return schedules.stream().distinct().map(sch -> formatter.format(sch)).collect(Collectors.toList());
    }


    public Scheduling toScheduling(SchedulingDTO dto){
        User user = userRepository.getReferenceById(dto.getUserId());
        Doctor doctor = doctorRepository.getReferenceById(dto.getDoctorId());
        Scheduling scheduling = new Scheduling();
        scheduling.setUser(user);
        scheduling.setDoctor(doctor);
        return scheduling;
    }
}
