package com.melck.mckthymeleaf.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.melck.mckthymeleaf.models.Scheduling;
import com.melck.mckthymeleaf.models.user.User;
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
    private AuthService authService;

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
}
