package com.melck.mckthymeleaf.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.melck.mckthymeleaf.dtos.SchedulingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
}
